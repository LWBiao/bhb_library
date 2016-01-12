package com.bhb.mall.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import com.bhb.mall.model.Book;
import com.bhb.mall.model.BookWithType;
import com.bhb.mall.model.SolrBook;

public interface BookService {
	
	int save(Book book);
	
	int delete(Book book);
	
	int update(Book book);
	
	public List<Book> findAll();
	
	List<BookWithType> findBookWithType();
	
	Book findById(String id);
}
