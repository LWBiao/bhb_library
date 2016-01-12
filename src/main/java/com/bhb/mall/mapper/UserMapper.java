package com.bhb.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.bhb.mall.model.User;

@Component(value="userMapper")
public interface UserMapper  extends BaseMapper<User>{
	
	List<User> selectAll();
	
	User selectById(@Param("id") int id);
}