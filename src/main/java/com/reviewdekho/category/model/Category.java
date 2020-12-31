package com.reviewdekho.category.model;

import java.sql.Timestamp;
/*
 "category":{
		"category_id":2,
		"category_name":"Electronics",
		"category_created_at":"2020-12-07T03:57:58.000+00:00",
		"category_updated_at":"2020-12-25T07:14:58.000+00:00"
	},
 */
public class Category {
	private Integer category_id;
	private String category_name;
	private Timestamp category_created_at;
	private Timestamp category_updated_at;
	
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Timestamp getCategory_created_at() {
		return category_created_at;
	}
	public void setCategory_created_at(Timestamp category_created_at) {
		this.category_created_at = category_created_at;
	}
	public Timestamp getCategory_updated_at() {
		return category_updated_at;
	}
	public void setCategory_updated_at(Timestamp category_updated_at) {
		this.category_updated_at = category_updated_at;
	}
}
