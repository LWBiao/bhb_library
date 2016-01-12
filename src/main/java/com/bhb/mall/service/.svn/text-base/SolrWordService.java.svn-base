package com.bhb.mall.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;

import com.bhb.mall.model.SolrWord;

public interface SolrWordService {
	
	int save(SolrWord solrWord);
	
	int delete(SolrWord solrWord);
	
	int update(SolrWord solrWord);
	
	public List<SolrWord> findAll();
	
	SolrWord findById(String id);
	
	String[] getSearchPromptArray(String keyword);
	
	SolrQuery getSolrWordSuggestQuery(String prefix, Integer limit);

	boolean createSolrWordIndex() throws IOException, SolrServerException;
}
