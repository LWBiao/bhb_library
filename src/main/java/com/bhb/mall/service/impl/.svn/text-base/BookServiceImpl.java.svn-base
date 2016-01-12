package com.bhb.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bhb.mall.dao.BookDao;
import com.bhb.mall.model.Book;
import com.bhb.mall.model.BookWithType;
import com.bhb.mall.service.BookService;
import com.bhb.mall.service.TypeService;

@Service("bookService")
public class BookServiceImpl implements BookService{

	
	@Resource(name="bookDao")
	private BookDao bookDao;
	
	@Resource(name="typeService") 
	private TypeService typeService; 

	public int save(Book book) {
		return bookDao.save(book);
	}

	public int delete(Book book) {
		return bookDao.delete(book);
	}

	public int update(Book book) {
		return bookDao.update(book);
	}

	public List<Book> findAll() {
		return bookDao.findAll();
	}

	public Book findById(String id) {
		return bookDao.findById(id);
	}
	
	public List<BookWithType> findBookWithType() {
		return bookDao.findBookWithType();
	}

}
