package com.bhb.mall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.Alias;

@Table(name="t_book")
@Alias("Book")
public class Book extends MyBatisPojo{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	@Column
    private String bookName;
	@Column
    private int typeId;
	@Column
    private String isbn;
	@Column
    private String author;
	@Column
    private String authorIntroduction;
	@Column
    private Integer bookOrder;
	@Column
    private Integer amount;
	@Column
    private Integer wordCount;
	@Column
    private String introduction;
	@Column
    private Integer scoreNum;
	@Column
	private Integer scoreCount;
	@Column
    private String cover;
	@Column
    private int publisherId;
	@Column
    private Date publishTime;
	@Column
    private Date groundingTime;
	@Column
    private Date underCarriageTime;
	@Column
    private Date createTime;
	@Column
    private Date lastUpdateTime;
	@Column
    private String bookStatus;
	@Column
    private Integer viewNum;
	@Column
    private Integer commentNum;
	@Column
    private String source;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
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
        this.cover = cover == null ? null : cover.trim();
    }

    public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getBookOrder() {
		return bookOrder;
	}

	public void setBookOrder(Integer bookOrder) {
		this.bookOrder = bookOrder;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getAuthorIntroduction() {
		return authorIntroduction;
	}

	public void setAuthorIntroduction(String authorIntroduction) {
		this.authorIntroduction = authorIntroduction;
	}

	public Integer getWordCount() {
		return wordCount;
	}

	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
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

	public Date getUnderCarriageTime() {
		return underCarriageTime;
	}

	public void setUnderCarriageTime(Date underCarriageTime) {
		this.underCarriageTime = underCarriageTime;
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
    
    
}