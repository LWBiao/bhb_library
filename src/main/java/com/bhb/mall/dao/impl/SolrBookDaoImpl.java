package com.bhb.mall.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhb.mall.dao.SolrBookDao;
import com.bhb.mall.mapper.SolrBookMapper;
import com.bhb.mall.model.SolrBook;
import com.bhb.mall.utils.MybatisHelper;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:dao实现
 * @author:Eric
 * @date:2015年11月11日
 * @version:V1.0
 */
@Repository("solrBookDao")
@EqualsAndHashCode(callSuper=false)
public @Data class SolrBookDaoImpl extends MybatisHelper implements SolrBookDao{
	@Autowired
	private SolrBookMapper solrBookMapper;
	@Autowired
	private MybatisHelper mybatisHelper;

	public int save(SolrBook solrBook) {
		return solrBookMapper.insert(solrBook);
	}

	public int delete(SolrBook solrBook) {
		return solrBookMapper.delete(solrBook);
	}

	public int update(SolrBook solrBook) {
		return solrBookMapper.update(solrBook);
	}

	public List<SolrBook> findAll() {
		return solrBookMapper.selectAll();
	}

	public SolrBook findById(String id) {
		return null;
	}
	
	public List<SolrBook> findPage(){
		
		return null;
		
	}

}
