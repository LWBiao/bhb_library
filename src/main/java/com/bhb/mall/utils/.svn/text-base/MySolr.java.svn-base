package com.bhb.mall.utils;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

/**
 * solr工具类
 */
public class MySolr {

	// solr url
	public static final String URL = "http://localhost:8081/solr";
	
	public static SolrClient getSolrClient(String server) {
		return new HttpSolrClient(URL + "/" + server);
	}

}
