package com.bhb.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bhb.mall.dao.UserDao;
import com.bhb.mall.model.User;
import com.bhb.mall.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userDao")
	private UserDao userDao;

	public int save(User user) {
		return userDao.save(user);
	}

	public int delete(User user) {
		return userDao.delete(user);
	}

	public int update(User user) {
		return userDao.update(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findById(int id) {
		return userDao.findById(id);
	}

}
