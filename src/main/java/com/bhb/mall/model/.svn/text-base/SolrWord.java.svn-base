package com.bhb.mall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.Alias;
import org.apache.solr.client.solrj.beans.Field;

@Table(name="solr_word")
@Alias("SolrWord")
public class SolrWord extends MyBatisPojo{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Field
	@Id
	private Integer id;
	@Field
	@Column
    private String words;
	@Field
	@Column
    private int frequency;
	@Column
    private Date createTime;
	@Column
    private Date lastUpdateTime;
	@Field
	private String[] pinyin;
	@Field
	private String[] abbre;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String[] getPinyin() {
		return pinyin;
	}
	public void setPinyin(String[] pinyin) {
		this.pinyin = pinyin;
	}
	public String[] getAbbre() {
		return abbre;
	}
	public void setAbbre(String[] abbre) {
		this.abbre = abbre;
	}


   
    
}