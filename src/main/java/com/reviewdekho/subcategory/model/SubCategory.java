package com.reviewdekho.subcategory.model;

import java.sql.Timestamp;

import com.reviewdekho.category.model.Category;
/*
{
	"sub_category_id":6,
	"category":{
		"category_id":2,
		"category_name":"Electronics",
		"category_created_at":"2020-12-07T03:57:58.000+00:00",
		"category_updated_at":"2020-12-25T07:14:58.000+00:00"
	},
	"sub_category_name":"Laptop",
	"sub_category_created_at":"2020-11-11T16:11:30.000+00:00",
	"sub_category_updated_at":"2020-11-11T16:11:30.000+00:00"
	},
*/
public class SubCategory {
	private Integer sub_category_id;
	private String sub_category_name;
	private Category category;
	private Timestamp sub_category_created_at;
	private Timestamp sub_category_updated_at;
	
	public SubCategory() {
		
	}

	public Integer getSub_category_id() {
		return sub_category_id;
	}

	public void setSub_category_id(Integer sub_category_id) {
		this.sub_category_id = sub_category_id;
	}

	public String getSub_category_name() {
		return sub_category_name;
	}

	public void setSub_category_name(String sub_category_name) {
		this.sub_category_name = sub_category_name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Timestamp getSub_category_created_at() {
		return sub_category_created_at;
	}

	public void setSub_category_created_at(Timestamp sub_category_created_at) {
		this.sub_category_created_at = sub_category_created_at;
	}

	public Timestamp getSub_category_updated_at() {
		return sub_category_updated_at;
	}

	public void setSub_category_updated_at(Timestamp sub_category_updated_at) {
		this.sub_category_updated_at = sub_category_updated_at;
	}
	
}
