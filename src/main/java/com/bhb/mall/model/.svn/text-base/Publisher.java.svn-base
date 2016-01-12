package com.bhb.mall.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.Alias;

@Table(name="t_publisher")
@Alias("Publisher")
public class Publisher  extends MyBatisPojo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private Integer id;
	@Column
    private String name;
	@Column
    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}