package com.bhb.mall.template;


import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.bhb.mall.model.MyBatisPojo;

public class CUDTemplate<T extends MyBatisPojo> {
	@SuppressWarnings("deprecation")
	public String insert(T obj) {
		BEGIN();
		
		INSERT_INTO(obj.tablename());
		obj.caculationColumnList();
		VALUES(obj.returnInsertColumnsName(), obj.returnInsertColumnsDefine());

		return SQL();
	}
	
	@SuppressWarnings("deprecation")
	public String update(T obj) {
		String idname = obj.id();
		
		BEGIN();
		
		UPDATE(obj.tablename());
		obj.caculationColumnList();
		SET(obj.returnUpdateSet());
		WHERE(idname + "=#{" + idname + "}");
		
		return SQL();
	}
	
	@SuppressWarnings("deprecation")
	public String delete(T obj) {
		String idname = obj.id();
		
		BEGIN();
		
		DELETE_FROM(obj.tablename());
		WHERE(idname + "=#{" + idname + "}");
		
		return SQL();
	}
//	@SuppressWarnings("deprecation")
//	public String delete(T obj) {
//		String idname = obj.id();
//		
//		BEGIN();
//		
//		DELETE_FROM(obj.tablename());
//		WHERE(idname + "=#{" + idname + "}");
//		
//		return SQL();
//	}
}

