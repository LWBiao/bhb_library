package com.bhb.mall.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.StringUtils;
import org.springframework.stereotype.Service;

import com.bhb.mall.dao.SolrBookDao;
import com.bhb.mall.model.SolrBook;
import com.bhb.mall.service.SolrBookService;
import com.bhb.mall.service.TypeService;
import com.bhb.mall.utils.DataPage;
import com.bhb.mall.utils.MySolr;
import com.bhb.mall.utils.Page;
import com.bhb.mall.utils.Pinyin4jUtil;

@Service("solrBookService")
public class SolrBookServiceImpl implements SolrBookService {

	public final static String TYPE_CODE = "cType";
	public final static String PUBLISHER_CODE = "pub";
	public final static int PAGE_SIZE = 10;

	@Resource(name = "solrBookDao")
	private SolrBookDao solrBookDao;

	@Resource(name = "typeService")
	private TypeService typeService;

	public int save(SolrBook solrBook) {
		return solrBookDao.save(solrBook);
	}

	public int delete(SolrBook solrBook) {
		return solrBookDao.delete(solrBook);
	}

	public int update(SolrBook solrBook) {
		return solrBookDao.update(solrBook);
	}

	public List<SolrBook> findAll() {
		return solrBookDao.findAll();
	}

	public SolrBook findById(String id) {
		return solrBookDao.findById(id);
	}

	/**
	 * 关键字查询书本 流程1
	 */
	public DataPage<SolrBook> searchSolrBookByKey(String keyword, Page page) {
		String keywordParam = Pinyin4jUtil.encodeStr(keyword);
		SolrClient client = MySolr.getSolrClient("solrBook");
		QueryResponse response = new QueryResponse();
		// List<SolrBook> solrBookList = new ArrayList<SolrBook>();
		// System.out.println(keyword);

		SolrQuery solrQuery = getSolrBookKeyQuery(keywordParam.toLowerCase(), page);
		try {
			response = client.query(solrQuery);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DataPage<SolrBook> dataPage = new DataPage<SolrBook>();
		dataPage.setDatalist(response.getBeans(SolrBook.class));
		dataPage.setPageCount(getPageCount(response.getResults()));

		return dataPage;
	}

	/**
	 * 设置书本关键字查询条件 流程2
	 */
	public SolrQuery getSolrBookKeyQuery(String keyword, Page page) {
		SolrQuery solrQuery = new SolrQuery();
		StringBuilder sb = new StringBuilder();
		sb.append("id : 0 ");

		// 分词、拼接关键字查询条件 TODO
		List<Term> keyList = ToAnalysis.parse(keyword);
		for (Term term : keyList) {
			String termKey = term.getName();
			
			
			
			sb.append("OR pinyin:*").append(termKey).append("* ");
			sb.append("OR abbre:*").append(termKey).append("* ");
			
			sb.append("OR bookName:*").append(termKey).append("* ");
			sb.append("OR author:*").append(termKey).append("* ");
			sb.append("OR introduction:*").append(termKey).append("* ");
			sb.append("OR authorIntroduction:*").append(termKey).append("* ");
			sb.append("OR typeName:*").append(termKey).append("* ");
		}

		solrQuery.setQuery(sb.toString());
		setFields(solrQuery);

		solrQuery.addSort("viewNum", SolrQuery.ORDER.desc);
		solrQuery.setStart(page.getStart() * page.getPageSize());
		solrQuery.setRows(page.getPageSize());

		return solrQuery;
	}

	/**
	 * 条件查询书本 流程1
	 */
	public DataPage<SolrBook> searchSolrBookByCondition(String[] conditions, Page page) {

		SolrClient client = MySolr.getSolrClient("solrBook");
		QueryResponse response = new QueryResponse();
		// List<SolrBook> solrBookList = new ArrayList<SolrBook>();

		if (conditions.length > 0) {
			SolrQuery solrQuery = getSolrBookConditionQuery(conditions, page);
			try {
				response = client.query(solrQuery);
			} catch (SolrServerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		DataPage<SolrBook> dataPage = new DataPage<SolrBook>();
		dataPage.setDatalist(response.getBeans(SolrBook.class));
		dataPage.setPageCount(getPageCount(response.getResults()));

		return dataPage;
	}

	/**
	 * 设置书本条件查询条件 流程2
	 */
	public SolrQuery getSolrBookConditionQuery(String[] conditions, Page page) {
		SolrQuery solrQuery = new SolrQuery();
		StringBuilder sb = new StringBuilder();

		sb.append(" * : * ");

		// 类型查询
		List<String> typeList = new ArrayList<String>();
		for (String condition : conditions) {
			if (TYPE_CODE.equals(condition.split("-")[0])) {
				typeList.add(condition.split("-")[1]);
			}
		}

		// 出版社查询
		List<String> publisherList = new ArrayList<String>();
		for (String condition : conditions) {
			if (PUBLISHER_CODE.equals(condition.split("-")[0])) {
				publisherList.add(condition.split("-")[1]);
			}
		}

		// 其他查询 未定 TODO

		if (typeList.size() > 0) {
			sb.append(" AND ").append(" ( ");
			for (int i = 0; i < typeList.size(); i++) {
				switch (i) {
				case 0: {
					sb.append(" bookType : ").append(typeList.get(i));
					break;
				}
				default: {
					sb.append(" OR bookType : ").append(typeList.get(i));
					break;
				}
				}
			}
			sb.append(" ) ");
		}

		if (publisherList.size() > 0) {
			sb.append(" AND ").append(" ( ");
			for (int i = 0; i < publisherList.size(); i++) {
				switch (i) {
				case 0: {
					sb.append(" publisherId : ").append(publisherList.get(i));
					break;
				}
				default: {
					sb.append(" OR publisherId : ").append(publisherList.get(i));
					break;
				}
				}
			}
			sb.append(" ) ");
		}

		solrQuery.setQuery(sb.toString());
		setFields(solrQuery);

		solrQuery.addSort("viewNum", SolrQuery.ORDER.desc);
		solrQuery.setStart(page.getStart() * page.getPageSize());
		solrQuery.setRows(page.getPageSize());

		return solrQuery;
	}

	/**
	 * 全查询书本 流程1
	 */
	public DataPage<SolrBook> searchAllSolrBook(Page page) {

		SolrClient client = MySolr.getSolrClient("solrBook");
		QueryResponse response = new QueryResponse();
		// List<SolrBook> solrBookList = new ArrayList<SolrBook>();
		SolrQuery solrQuery = getSolrBookAllQuery(page);
		try {
			response = client.query(solrQuery);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DataPage<SolrBook> dataPage = new DataPage<SolrBook>();
		dataPage.setDatalist(response.getBeans(SolrBook.class));
		dataPage.setPageCount(getPageCount(response.getResults()));

		return dataPage;
	}

	/**
	 * 设置书本全查询条件 流程2
	 */
	public SolrQuery getSolrBookAllQuery(Page page) {
		SolrQuery solrQuery = new SolrQuery();
		StringBuilder sb = new StringBuilder();
		sb.append(" *:*");
		solrQuery.setQuery(sb.toString());
		setFields(solrQuery);
		solrQuery.addSort("viewNum", SolrQuery.ORDER.desc);
		solrQuery.setStart(page.getStart() * page.getPageSize());
		solrQuery.setRows(page.getPageSize());

		return solrQuery;
	}

	/**
	 * 设置查询字段
	 */
	public void setFields(SolrQuery solrQuery) {
		solrQuery.addField("id");
		solrQuery.addField("bookName");
		solrQuery.addField("typeId");
		solrQuery.addField("typeName");
		solrQuery.addField("typeCode");
		solrQuery.addField("isbn");
		solrQuery.addField("author");
		solrQuery.addField("authorIntroduction");
		solrQuery.addField("bookOrder");
		solrQuery.addField("amount");
		solrQuery.addField("wordCount");
		solrQuery.addField("introduction");
		solrQuery.addField("scoreNum");
		solrQuery.addField("scoreCount");
		solrQuery.addField("cover");
		solrQuery.addField("publisherId");
		solrQuery.addField("publisherName");
		solrQuery.addField("publisherCode");
		solrQuery.addField("publishTime");
		solrQuery.addField("groundingTime");
		solrQuery.addField("underCarriageTime");
		solrQuery.addField("createTime");
		solrQuery.addField("lastUpdateTime");
		solrQuery.addField("bookStatus");
		solrQuery.addField("viewNum");
		solrQuery.addField("bookType");
		solrQuery.addField("commentNum");
		solrQuery.addField("source");
	}

	/**
	 * 创建solrBook索引-----------------------------------------------------new
	 */
	public boolean createSolrBookIndex() throws IOException, SolrServerException {
		List<SolrBook> solrBookList = findAll();
		SolrClient client = MySolr.getSolrClient("solrBook");
		for (SolrBook solrBook : solrBookList) {

			List<Term> termList = new ArrayList<Term>();

			// 获取关键字属性域分词
			if (!StringUtils.isEmpty(solrBook.getBookName())) {
				List<Term> bookNameTerms = ToAnalysis.parse(solrBook.getBookName());
				termList.addAll(bookNameTerms);
			}
			if (!StringUtils.isEmpty(solrBook.getIntroduction())) {
				List<Term> introductionTerms = ToAnalysis.parse(solrBook.getIntroduction());
				termList.addAll(introductionTerms);
			}
			if (!StringUtils.isEmpty(solrBook.getTypeName())) {
				List<Term> typeNameTerms = ToAnalysis.parse(solrBook.getTypeName());
				termList.addAll(typeNameTerms);
			}
			if (!StringUtils.isEmpty(solrBook.getAuthor())) {
				List<Term> authorTerms = ToAnalysis.parse(solrBook.getAuthor());
				termList.addAll(authorTerms);
			}
			if (!StringUtils.isEmpty(solrBook.getAuthorIntroduction())) {
				List<Term> authorIntroductionTerms = ToAnalysis.parse(solrBook.getAuthorIntroduction());
				termList.addAll(authorIntroductionTerms);
			}

			StringBuilder pinyinSb = new StringBuilder();
			StringBuilder abbreSb = new StringBuilder();
			int length = termList.size();
			for (int i = 0; i < length; i++) {
				pinyinSb.append(Pinyin4jUtil.converterToSpell(termList.get(i).getName()));
				abbreSb.append(Pinyin4jUtil.converterToFirstSpell(termList.get(i).getName()));
				if (i != length - 1) {
					pinyinSb.append(",");
					abbreSb.append(",");
				}
			}
			solrBook.setPinyin(array_unique(Pinyin4jUtil.string2Array(pinyinSb.toString())));
			solrBook.setAbbre((Pinyin4jUtil.string2Array(abbreSb.toString())));

			List<Integer> typeIdList = typeService.findIdsByBookId(solrBook.getId());
			Integer[] arr = (Integer[]) typeIdList.toArray(new Integer[typeIdList.size()]);
			solrBook.setBookType(arr);
			client.addBean(solrBook);
		}
		client.commit();
		return true;
	}

	/**
	 * 页数
	 */
	public long getPageCount(SolrDocumentList docList) {
		if (docList.getNumFound() / PAGE_SIZE != 0) {
			return docList.getNumFound() / PAGE_SIZE + 1;
		} else {
			return docList.getNumFound() / PAGE_SIZE;
		}
	}

	// 去除数组中重复的记录
	public static String[] array_unique(String[] array) {
		// array_unique
		List<String> list = new LinkedList<String>();
		for (int i = 0; i < array.length; i++) {
			if (!list.contains(array[i])) {
				list.add(array[i]);
			}
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	public static void main(String[] args) {
//		List<Term> t1 = ToAnalysis.parse("大千世界");
//		List<Term> t2 = ToAnalysis.parse("无奇不有");
//		List<Term> t3 = new ArrayList<Term>();
//		t3.addAll(t1);
//		t3.addAll(t2);
//		StringBuilder sb = new StringBuilder();
//		int length = t3.size();
//		for (int i = 0; i < length; i++) {
//			sb.append(Pinyin4jUtil.converterToSpell(t3.get(i).getName()));
//			if (i != length - 1) {
//				sb.append(",");
//			}
//		}
//
//		System.out.println(sb.toString());
//		System.out.println(Pinyin4jUtil.string2Array(sb.toString()).length);
		List<Term> keyList = ToAnalysis.parse("absdbasudbuas");
		System.out.println("是的".toLowerCase());

	}

}
