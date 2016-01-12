package com.bhb.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bhb.mall.dao.TypeDao;
import com.bhb.mall.model.Type;
import com.bhb.mall.service.TypeService;

@Service("typeService")
public class TypeServiceImpl implements TypeService{

	
	@Resource(name="typeDao")
	private TypeDao typeDao;

	public int save(Type type) {
		return typeDao.save(type);
	}

	public int delete(Type type) {
		return typeDao.delete(type);
	}

	public int update(Type type) {
		return typeDao.update(type);
	}

	public List<Type> findAll() {
		return typeDao.findAll();
	}

	public Type findById(int id) {
		return typeDao.findById(id);
	}

	public List<Integer> findIdsByBookId(int bookId) {
		return typeDao.findIdsByBookId(bookId);
	}

	public List<Type> findByCondition(Type condition) {
		return typeDao.findByCondition(condition);
	}

	public List<Type> findByIds(int[] ids) {
		return typeDao.findByIds(ids);
	}

}
