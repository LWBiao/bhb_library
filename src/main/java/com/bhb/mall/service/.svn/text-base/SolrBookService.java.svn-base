package com.bhb.mall.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import com.bhb.mall.model.SolrBook;
import com.bhb.mall.utils.DataPage;
import com.bhb.mall.utils.Page;

public interface SolrBookService {
	
	int save(SolrBook solrBook);
	
	int delete(SolrBook solrBook);
	
	int update(SolrBook solrBook);
	
	public List<SolrBook> findAll();
	
	SolrBook findById(String id);

	boolean createSolrBookIndex() throws IOException, SolrServerException;
	
	DataPage<SolrBook> searchSolrBookByKey(String keyword, Page page);

	DataPage<SolrBook> searchSolrBookByCondition(String[] conditions, Page page);
	
	DataPage<SolrBook> searchAllSolrBook(Page page);
}
