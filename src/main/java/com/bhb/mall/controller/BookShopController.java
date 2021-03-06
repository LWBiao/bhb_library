package com.bhb.mall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bhb.mall.model.Publisher;
import com.bhb.mall.model.SolrBook;
import com.bhb.mall.model.Type;
import com.bhb.mall.service.BookService;
import com.bhb.mall.service.PublisherService;
import com.bhb.mall.service.SolrBookService;
import com.bhb.mall.service.TypeService;
import com.bhb.mall.service.SolrWordService;
import com.bhb.mall.utils.DataPage;
import com.bhb.mall.utils.Page;
import com.bhb.mall.utils.Pinyin4jUtil;

import lombok.Data;

/**
 * @Description:测试controller
 * @author:Eric
 * @date:2015年11月9日
 * @version:V1.0
 */

@Controller
@RequestMapping("bookShop")
public @Data class BookShopController {
	@Resource(name = "bookService")
	private BookService bookService;
	@Resource(name = "solrBookService")
	private SolrBookService solrBookService;
	@Resource(name = "typeService")
	private TypeService typeService;
	@Resource(name = "solrWordService")
	private SolrWordService solrWordService;
	@Resource(name = "publisherService")
	private PublisherService publisherService;

	@RequestMapping("/showPage")
	public String showPage(Map<String, Object> map) {
		return "bookShop";
	}

	@RequestMapping("/searchAllBook")
	@ResponseBody
	public Map<String, Object> searchAllBook(Page page) {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		DataPage<SolrBook> solrBookList = solrBookService.searchAllSolrBook(page);
		resultMap.put("books", JSON.toJSONString(solrBookList.getDatalist()));
		resultMap.put("pageCount", solrBookList.getPageCount());
		return resultMap;
	}

	@RequestMapping("/searchBookByKey")
	@ResponseBody
	public Map<String, Object> searchBookByKey(String keyword, Page page) {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		DataPage<SolrBook> solrBookList = solrBookService.searchSolrBookByKey(keyword, page);
		resultMap.put("books", JSON.toJSONString(solrBookList.getDatalist()));
		resultMap.put("pageCount", solrBookList.getPageCount());
		return resultMap;
	}

	@RequestMapping("/searchBookByCondition")
	@ResponseBody
	public Map<String, Object> searchBookByCondition(String[] conditions, Page page) {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		DataPage<SolrBook> solrBookList = solrBookService.searchSolrBookByCondition(conditions, page);
		resultMap.put("books", JSON.toJSONString(solrBookList.getDatalist()));
		resultMap.put("pageCount", solrBookList.getPageCount());
		return resultMap;
	}

	@RequestMapping("/searchType")
	@ResponseBody
	public Map<String, Object> searchType(String a) {

		Type condition = new Type();
		condition.setLevel(0);
		List<Type> typeList = typeService.findByCondition(condition);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("types", JSON.toJSONString(typeList));
		return resultMap;
	}

	@RequestMapping("/searchChildrenType")
	@ResponseBody
	public Map<String, Object> searchChildrenType(String[] types) {

		Type condition = new Type();
		condition.setPid(Integer.valueOf(types[1]));
		List<Type> childrenTypeList = typeService.findByCondition(condition);
		Type type = typeService.findById(Integer.valueOf(types[1]));
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("childrenTypes", JSON.toJSONString(childrenTypeList));
		resultMap.put("type", JSON.toJSONString(type));
		return resultMap;
	}

	@RequestMapping("/searchPublisher")
	@ResponseBody
	public Map<String, Object> searchPublisher() {

		List<Publisher> publisherList = publisherService.findAll();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("publishers", JSON.toJSONString(publisherList));
		return resultMap;
	}

	@RequestMapping("/searchPrompt")
	@ResponseBody
	public Map<String, Object> searchPrompt(String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("availableTags", solrWordService.getSearchPromptArray(keyword));
		return map;
	}

}
