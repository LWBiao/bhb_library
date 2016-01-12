package com.bhb.mall.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhb.mall.dao.BookDao;
import com.bhb.mall.mapper.BookMapper;
import com.bhb.mall.mapper.BookWithTypeMapper;
import com.bhb.mall.model.Book;
import com.bhb.mall.model.BookWithType;
import com.bhb.mall.utils.MybatisHelper;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:dao实现
 * @author:Eric
 * @date:2015年11月11日
 * @version:V1.0
 */
@Repository("bookDao")
@EqualsAndHashCode(callSuper=false)
public @Data class BookDaoImpl extends MybatisHelper implements BookDao{
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private BookWithTypeMapper bookWithTypeMapper;
	@Autowired
	private MybatisHelper mybatisHelper;

	public int save(Book book) {
		return bookMapper.insert(book);
	}

	public int delete(Book book) {
		return bookMapper.delete(book);
	}

	public int update(Book book) {
		return bookMapper.update(book);
	}

	public List<Book> findAll() {
		return bookMapper.selectAll();
	}

	public Book findById(String id) {
		return null;
	}
	
	public List<Book> findPage(){
		
		return null;
		
	}

	public List<BookWithType> findBookWithType() {
		return bookWithTypeMapper.selectBookWithType();
	}

}
