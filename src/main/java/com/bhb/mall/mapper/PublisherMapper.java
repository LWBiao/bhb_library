package com.bhb.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.bhb.mall.model.Publisher;

@Component(value="publisherMapper")
public interface PublisherMapper   extends BaseMapper<Publisher>{
	List<Publisher> selectAll();

	Publisher selectById(@Param("id") int id);
}