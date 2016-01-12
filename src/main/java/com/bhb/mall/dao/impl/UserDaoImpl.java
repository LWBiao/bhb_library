package com.bhb.mall.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhb.mall.dao.UserDao;
import com.bhb.mall.mapper.UserMapper;
import com.bhb.mall.model.User;
import com.bhb.mall.utils.MybatisHelper;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:dao实现
 * @author:Eric
 * @date:2015年11月11日
 * @version:V1.0
 */
@Repository("userDao")
@EqualsAndHashCode(callSuper=false)
public @Data class UserDaoImpl extends MybatisHelper implements UserDao{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MybatisHelper mybatisHelper;

	public int save(User user) {
		return userMapper.insert(user);
	}

	public int delete(User user) {
		return userMapper.delete(user);
	}

	public int update(User user) {
		return userMapper.update(user);
	}

	public List<User> findAll() {
		return userMapper.selectAll();
	}

	public User findById(int id) {
		return userMapper.selectById(id);
	}
	
}
