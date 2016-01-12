package com.bhb.mall.service;

import java.util.List;

import com.bhb.mall.model.Type;

public interface TypeService {
	
	int save(Type type);
	
	int delete(Type type);
	
	int update(Type type);
	
	List<Type> findAll();
	
	List<Integer> findIdsByBookId(int bookId);
	
	Type findById(int id);
	
	List<Type> findByIds(int[] ids);
	
	List<Type> findByCondition(Type condition);
	
}
