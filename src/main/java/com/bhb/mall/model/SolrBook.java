package com.bhb.mall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.Alias;
import org.apache.solr.client.solrj.beans.Field;

@Table(name="solr_book")
@Alias("SolrBook")
public class SolrBook  extends MyBatisPojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Field
	private Integer id;
	@Column
	@Field
    private String bookName;
	@Column
	@Field
    private int typeId;
	@Column
	@Field
    private String isbn;
	@Column
	@Field
    private String author;
	@Column
	@Field
    private String authorIntroduction;
	@Column
	@Field
    private Integer bookOrder;
	@Column
	@Field
    private Integer amount;
	@Column
	@Field
    private Integer wordCount;
	@Column
	@Field
    private String introduction;
	@Column
	@Field
    private Integer scoreNum;
	@Column
	@Field
	private Integer scoreCount;
	@Column
	@Field
    private String cover;
	@Column
	@Field
    private int publisherId;
	@Column
	@Field
	private String publisherName;
	@Column
	@Field
	private String publisherCode;
	@Column
	@Field
    private Date publishTime;
	@Column
	@Field
    private Date groundingTime;
	@Column
	@Field
    private Date underCarriageTime;
	@Column
	@Field
    private Date createTime;
	@Column
	@Field
    private Date lastUpdateTime;
	@Column
	@Field
    private String bookStatus;
	@Column
	@Field
    private Integer viewNum;
	@Column
	@Field
    private Integer commentNum;
	@Column
	@Field
    private String source;
	@Column
	@Field
	private String typeName;
	@Column
	@Field
	private String typeCode;
	
	@Field
	private Integer[] bookType;
	@Field
	private String[] nameParticiple;
	
	@Field
	private String[] pinyin;
	@Field
	private String[] abbre;
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getBookOrder() {
		return bookOrder;
	}
	public void setBookOrder(Integer bookOrder) {
		this.bookOrder = bookOrder;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getWordCount() {
		return wordCount;
	}
	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	
	public Integer getScoreNum() {
		return scoreNum;
	}
	public void setScoreNum(Integer scoreNum) {
		this.scoreNum = scoreNum;
	}
	public Integer getScoreCount() {
		return scoreCount;
	}
	public void setScoreCount(Integer scoreCount) {
		this.scoreCount = scoreCount;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Date getGroundingTime() {
		return groundingTime;
	}
	public void setGroundingTime(Date groundingTime) {
		this.groundingTime = groundingTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public Integer getViewNum() {
		return viewNum;
	}
	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer[] getBookType() {
		return bookType;
	}
	public void setBookType(Integer[] bookType) {
		this.bookType = bookType;
	}
	public String[] getNameParticiple() {
		return nameParticiple;
	}
	public void setNameParticiple(String[] nameParticiple) {
		this.nameParticiple = nameParticiple;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getAuthorIntroduction() {
		return authorIntroduction;
	}
	public void setAuthorIntroduction(String authorIntroduction) {
		this.authorIntroduction = authorIntroduction;
	}
	public Date getUnderCarriageTime() {
		return underCarriageTime;
	}
	public void setUnderCarriageTime(Date underCarriageTime) {
		this.underCarriageTime = underCarriageTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getPublisherCode() {
		return publisherCode;
	}
	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}

}