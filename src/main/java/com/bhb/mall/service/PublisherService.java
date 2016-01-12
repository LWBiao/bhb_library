package com.bhb.mall.service;

import java.util.List;

import com.bhb.mall.model.Publisher;

public interface PublisherService {
	
	int save(Publisher publisher);
	
	int delete(Publisher publisher);
	
	int update(Publisher publisher);
	
	public List<Publisher> findAll();
	
	Publisher findById(int id);
	
}
