package com.bhb.mall.dao;

import java.util.List;

import com.bhb.mall.model.SolrWord;

/**
 * @Description:dao接口
 * @author:Eric
 * @date:2015年11月11日
 * @version:V1.0
 */

public interface SolrWordDao{
	
	int save(SolrWord solrWord);
	
	int delete(SolrWord solrWord);
	
	int update(SolrWord solrWord);
	
	List<SolrWord> findAll();
	
	SolrWord findById(String id);
}
