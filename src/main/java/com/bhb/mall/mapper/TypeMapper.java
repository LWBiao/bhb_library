package com.bhb.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.bhb.mall.model.Type;

@Component(value="typeMapper")
public interface TypeMapper  extends BaseMapper<Type>{
	List<Type> selectAll();
	
	List<Integer> selectIdsByBookId(@Param("bookId") int bookId);
	
	List<Type> selectByCondition(@Param("condition") Type condition);
	
	List<Type> selectByIds(@Param("ids") int[] ids);

	Type selectById(@Param("id") int id);
}