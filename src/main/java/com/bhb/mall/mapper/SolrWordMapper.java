package com.bhb.mall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bhb.mall.model.SolrWord;

@Component(value="solrWordMapper")
public interface SolrWordMapper  extends BaseMapper<SolrWord>{
	List<SolrWord> selectAll();
}