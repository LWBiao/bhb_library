package com.bhb.mall.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhb.mall.dao.TypeDao;
import com.bhb.mall.mapper.TypeMapper;
import com.bhb.mall.model.Type;
import com.bhb.mall.utils.MybatisHelper;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:dao实现
 * @author:Eric
 * @date:2015年11月11日
 * @version:V1.0
 */
@Repository("typeDao")
@EqualsAndHashCode(callSuper=false)
public @Data class TypeDaoImpl extends MybatisHelper implements TypeDao{
	@Autowired
	private TypeMapper typeMapper;
	@Autowired
	private MybatisHelper mybatisHelper;

	public int save(Type type) {
		return typeMapper.insert(type);
	}

	public int delete(Type type) {
		return typeMapper.delete(type);
	}

	public int update(Type type) {
		return typeMapper.update(type);
	}

	public List<Type> findAll() {
		return typeMapper.selectAll();
	}

	public Type findById(int id) {
		return typeMapper.selectById(id);
	}
	
	public List<Type> findPage(){
		return null;
	}

	public List<Integer> findIdsByBookId(int bookId) {
		return typeMapper.selectIdsByBookId(bookId);
	}

	public List<Type> findByCondition(Type condition) {
		return typeMapper.selectByCondition(condition);
	}

	public List<Type> findByIds(int[] ids) {
		return typeMapper.selectByIds(ids);
	}

}
