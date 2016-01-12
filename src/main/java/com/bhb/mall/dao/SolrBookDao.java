package com.bhb.mall.dao;

import java.util.List;

import com.bhb.mall.model.SolrBook;

/**
 * @Description:dao接口
 * @author:Eric
 * @date:2015年11月11日
 * @version:V1.0
 */

public interface SolrBookDao{
	
	int save(SolrBook solrBook);
	
	int delete(SolrBook solrBook);
	
	int update(SolrBook solrBook);
	
	List<SolrBook> findAll();
	
	SolrBook findById(String id);
}
