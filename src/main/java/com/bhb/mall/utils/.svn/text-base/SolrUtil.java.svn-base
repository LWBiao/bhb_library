package com.bhb.mall.utils;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.TermsResponse;
import org.apache.solr.client.solrj.response.TermsResponse.Term;
import org.apache.solr.common.SolrDocumentList;

public class SolrUtil {
	
	HttpSolrClient client;
	
	SolrUtil(){
		String url = "http://localhost:8081/solr/bhb_library";
		client = new HttpSolrClient(url);
		client.setSoTimeout(3000); // socket read timeout
		client.setConnectionTimeout(1000);
		client.setDefaultMaxConnectionsPerHost(1000);
		client.setMaxTotalConnections(10);
		client.setFollowRedirects(false); // defaults to false
		client.setAllowCompression(true);
	}

	public HttpSolrClient getClient() {
		return client;
	}

	public static void main(String[] args) throws SolrServerException, IOException {
		SolrUtil util = new SolrUtil();
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
				query.addField("id");
				query.addField("name");
				query.setStart(0);
				query.setRows(10);
				
				HttpSolrClient client = new SolrUtil().getClient();
				
				QueryResponse qrsp = client.query(query);  
		        SolrDocumentList docs = qrsp.getResults();
		        
		        System.out.println(docs.get(1).getFieldValue("id"));
		        System.out.println(docs.get(1));
		        
		        List<Term> list = util.query("s",10);
		        System.out.println("----------");
	}
	
	private List<Term> query(String q, int limit) throws IOException {
	    List<Term> items = null;
	    HttpSolrClient client = new SolrUtil().getClient();

	     // escape special characters
	     SolrQuery query = new SolrQuery();
	     query.addTermsField("spell");
	     query.setTerms(true);
	     query.setTermsLimit(limit);
	     query.setTermsLower(q);
	     query.setTermsPrefix(q);
	     query.setQuery("/terms");

	     try {
	         QueryResponse qr = client.query(query);
	         TermsResponse resp = qr.getTermsResponse();
	         items = resp.getTerms("spell");
	     } catch (SolrServerException e) {
	      	items = null;
	     }

	     return items;
	}
	
	

}
