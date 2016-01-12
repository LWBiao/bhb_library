package com.bhb.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bhb.mall.dao.PublisherDao;
import com.bhb.mall.model.Publisher;
import com.bhb.mall.service.PublisherService;

@Service("publisherService")
public class PublisherServiceImpl implements PublisherService{

	
	@Resource(name="publisherDao")
	private PublisherDao publisherDao;

	public int save(Publisher publisher) {
		return publisherDao.save(publisher);
	}

	public int delete(Publisher publisher) {
		return publisherDao.delete(publisher);
	}

	public int update(Publisher publisher) {
		return publisherDao.update(publisher);
	}

	public List<Publisher> findAll() {
		return publisherDao.findAll();
	}

	public Publisher findById(int id) {
		return publisherDao.findById(id);
	}

}
