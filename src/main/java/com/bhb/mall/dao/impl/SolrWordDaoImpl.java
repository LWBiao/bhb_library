package com.bhb.mall.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhb.mall.dao.SolrWordDao;
import com.bhb.mall.mapper.SolrWordMapper;
import com.bhb.mall.model.SolrWord;
import com.bhb.mall.utils.MybatisHelper;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:dao实现
 * @author:Eric
 * @date:2015年11月11日
 * @version:V1.0
 */
@Repository("solrWordDao")
@EqualsAndHashCode(callSuper=false)
public @Data class SolrWordDaoImpl extends MybatisHelper implements SolrWordDao{
	@Autowired
	private SolrWordMapper solrWordMapper;
	@Autowired
	private MybatisHelper mybatisHelper;

	public int save(SolrWord solrWord) {
		return solrWordMapper.insert(solrWord);
	}

	public int delete(SolrWord solrWord) {
		return solrWordMapper.delete(solrWord);
	}

	public int update(SolrWord solrWord) {
		return solrWordMapper.update(solrWord);
	}

	public List<SolrWord> findAll() {
		return solrWordMapper.selectAll();
	}

	public SolrWord findById(String id) {
		return null;
	}
	
	public List<SolrWord> findPage(){
		
		return null;
		
	}

}
