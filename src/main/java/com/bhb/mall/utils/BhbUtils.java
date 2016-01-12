package com.bhb.mall.utils;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bhb.mall.model.Book;
import com.bhb.mall.model.Publisher;
import com.bhb.mall.model.SolrBook;
import com.bhb.mall.model.SolrWord;
import com.bhb.mall.model.Type;
import com.bhb.mall.service.BookService;
import com.bhb.mall.service.PublisherService;
import com.bhb.mall.service.SolrBookService;
import com.bhb.mall.service.SolrWordService;
import com.bhb.mall.service.TypeService;

public class BhbUtils {

	static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");// 此文件放在SRC目录下

	// 智能提示service
	private static SolrWordService solrWordService = (SolrWordService) context.getBean("solrWordService");

	// 书本service
	private static BookService bookService = (BookService) context.getBean("bookService");

	private static // 搜索书本service
	SolrBookService solrBookService = (SolrBookService) context.getBean("solrBookService");

	// 类别service
	private static TypeService typeService = (TypeService) context.getBean("typeService");

	// 出版社service
	private static PublisherService publisherService = (PublisherService) context.getBean("publisherService");

	/**
	 * solrBook已有数据并且与book一一对应时，执行更新solrBook关联信息
	 */
	public static void updateSolrBook() {
		List<SolrBook> solrbookList = solrBookService.findAll();
		Publisher publisher = new Publisher();
		Type type = new Type();
		for (SolrBook solrBook : solrbookList) {

			// 插入出版社数据到solrbook
			publisher = publisherService.findById(solrBook.getPublisherId());
			solrBook.setPublisherName(publisher.getName());
			solrBook.setPublisherCode(publisher.getCode());

			type = typeService.findById(solrBook.getTypeId());
			solrBook.setTypeName(type.getName());
			solrBook.setTypeCode(type.getCode());

			solrBookService.update(solrBook);
		}
	}

	/**
	 * solrBook无数据时，执行插入solrBook关联信息
	 */
	public static void insertSolrBook() {
		List<Book> bookList = bookService.findAll();
		SolrBook solrBook = new SolrBook();
		Publisher publisher = new Publisher();
		Type type = new Type();
		for (Book book : bookList) {
			// 拷贝book数据到solrbook
			BeanUtils.copyProperties(book, solrBook);

			// 设置出版社数据到solrbook
			publisher = publisherService.findById(book.getPublisherId());
			solrBook.setPublisherName(publisher.getName());
			solrBook.setPublisherCode(publisher.getCode());

			// 设置书类别数据到solrbook
			type = typeService.findById(book.getTypeId());
			solrBook.setTypeName(type.getName());
			solrBook.setTypeCode(type.getCode());

			solrBookService.save(solrBook);
		}
	}

	/**
	 * 更新书本类别代码
	 */
	public static void updateTypeCode() {
		List<Type> typeList = typeService.findAll();
		for (Type type : typeList) {
			type.setCode(Pinyin4jUtil.converterToFirstSpell(type.getName()).split(",")[0]);
			typeService.update(type);
		}
	}

	/**
	 * 更新出版社代码
	 */
	public static void updatePublisherCode() {
		List<Publisher> publisherList = publisherService.findAll();
		for (Publisher publisher : publisherList) {
			publisher.setCode(Pinyin4jUtil.converterToFirstSpell(publisher.getName()).split(",")[0]);
			publisherService.update(publisher);
		}
	}

	/**
	 * solrWord无数据时，执行插入solrWord
	 */
	public static void insertsolrWord() {
		List<SolrBook> solrBookList = solrBookService.findAll(); 
		Set<String> solrWordSet = new HashSet<String>();
		for(SolrBook solrBook : solrBookList){
			processSolrWord(solrBook.getBookName(), solrWordSet);
			processSolrWord(solrBook.getTypeName(), solrWordSet);
			processSolrWord(solrBook.getIntroduction(), solrWordSet);
			processSolrWord(solrBook.getAuthor(), solrWordSet);
			processSolrWord(solrBook.getAuthorIntroduction(), solrWordSet);
		}
		for(String word : solrWordSet){
			SolrWord solrWord = new SolrWord();
			solrWord.setFrequency(0);
			solrWord.setWords(word);
			solrWordService.save(solrWord);
		}
		System.out.println("finish");
	}
	
	public static void processSolrWord(String wordParam, Set<String> solrWordSet){
		if(!StringUtils.isEmpty(wordParam)){
			List<Term> termList = ToAnalysis.parse(wordParam.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5]+",""));
			for (Term term : termList) {
				solrWordSet.add(term.getName());
			}
		}
		
	}
	

	public static void main(String[] args) {
//		insertsolrWord();
		try {
			// 创建soleBook索引
			solrBookService.createSolrBookIndex();
			// 创建soleWord索引
//			solrWordService.createSolrWordIndex();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

}
