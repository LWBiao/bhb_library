package com.bhb.mall.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Service;

import com.bhb.mall.dao.SolrWordDao;
import com.bhb.mall.model.SolrWord;
import com.bhb.mall.service.SolrWordService;
import com.bhb.mall.utils.MySolr;
import com.bhb.mall.utils.Pinyin4jUtil;

@Service("solrWordService")
public class SolrWordServiceImpl implements SolrWordService{

	
	@Resource(name="solrWordDao")
	private SolrWordDao solrWordDao;

	public int save(SolrWord solrWord) {
		return solrWordDao.save(solrWord);
	}

	public int delete(SolrWord solrWord) {
		return solrWordDao.delete(solrWord);
	}

	public int update(SolrWord solrWord) {
		return solrWordDao.update(solrWord);
	}

	public List<SolrWord> findAll() {
		return solrWordDao.findAll();
	}

	public SolrWord findById(String id) {
		return solrWordDao.findById(id);
	}
	
	/**
	 * 获取智能提示数组
	 */
	public String[] getSearchPromptArray(String keyword) {
		String keywordParam = Pinyin4jUtil.encodeStr(keyword);
		SolrClient client = MySolr.getSolrClient("solrWord");
		SolrQuery solrQuery = getSolrWordSuggestQuery(keywordParam.toLowerCase(), 10);
		String[] strArray = new String[10];
		for (int i = 0; i < strArray.length; i++) {
			strArray[i] = "";
		}
		QueryResponse response = new QueryResponse();
		try {
			response = client.query(solrQuery);
			List<SolrWord> solrWordList = response.getBeans(SolrWord.class);
			for (int i = 0; i < solrWordList.size(); i++) {
				strArray[i] = solrWordList.get(i).getWords();
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strArray;
	}
	
	/**
	 * 设置智能提示查询条件
	 */
	public SolrQuery getSolrWordSuggestQuery(String prefix, Integer limit) {
		SolrQuery solrQuery = new SolrQuery();
		StringBuilder sb = new StringBuilder();
		sb.append("words:").append(prefix).append("*");
		sb.append(" or pinyin:").append(prefix).append("*");
		sb.append(" or abbre:").append(prefix).append("*");
		solrQuery.setQuery(sb.toString());

		solrQuery.addField("words");
		solrQuery.addField("frequency");
		solrQuery.addSort("frequency", SolrQuery.ORDER.desc);
		solrQuery.setStart(0);
		solrQuery.setRows(limit);

		return solrQuery;
	}
	
	/**
	 * 创建智能搜索提示索引
	 */
	public  boolean createSolrWordIndex() throws IOException, SolrServerException{
		List<SolrWord> solrWordList = findAll();
		SolrClient client = MySolr.getSolrClient("solrWord");
		//先进行删除
		client.deleteByQuery("*:*");
		for(SolrWord solrWord : solrWordList){
			String solrWordContent = solrWord.getWords(); 
			solrWord.setPinyin(Pinyin4jUtil.string2Array(Pinyin4jUtil.converterToSpell(solrWordContent)));
			solrWord.setAbbre(Pinyin4jUtil.string2Array(Pinyin4jUtil.converterToFirstSpell(solrWordContent)));
			client.addBean(solrWord);
		}
		client.commit();
		return true;
	}
	
}
