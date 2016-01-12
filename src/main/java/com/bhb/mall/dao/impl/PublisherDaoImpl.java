package com.bhb.mall.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhb.mall.dao.PublisherDao;
import com.bhb.mall.mapper.PublisherMapper;
import com.bhb.mall.model.Publisher;
import com.bhb.mall.utils.MybatisHelper;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:dao实现
 * @author:Eric
 * @date:2015年11月11日
 * @version:V1.0
 */
@Repository("publisherDao")
@EqualsAndHashCode(callSuper=false)
public @Data class PublisherDaoImpl extends MybatisHelper implements PublisherDao{
	@Autowired
	private PublisherMapper publisherMapper;
	@Autowired
	private MybatisHelper mybatisHelper;

	public int save(Publisher publisher) {
		return publisherMapper.insert(publisher);
	}

	public int delete(Publisher publisher) {
		return publisherMapper.delete(publisher);
	}

	public int update(Publisher publisher) {
		return publisherMapper.update(publisher);
	}

	public List<Publisher> findAll() {
		return publisherMapper.selectAll();
	}

	public Publisher findById(int id) {
		return publisherMapper.selectById(id);
	}
	
	public List<Publisher> findPage(){
		return null;
	}

}
