package com.reviewdekho.product.model;

import com.reviewdekho.subcategory.model.SubCategory;
//
//{
//	"product_id":1,
//	"subCategory":
//	{"sub_category_id":6,"category":{"category_id":2,"category_name":"Electronics","category_created_at":"2020-12-07T03:57:58.000+00:00","category_updated_at":"2020-12-25T07:14:58.000+00:00"},"sub_category_name":"Laptop","sub_category_created_at":"2020-11-11T16:11:30.000+00:00","sub_category_updated_at":"2020-11-11T16:11:30.000+00:00"},
//	"product_name":"MacBook Pro 15 inch",
//	"product_desc":"MacBook Pro 15 inch",
//	"product_price":170000,
//	"product_created_at":"2020-11-11T11:02:40.000+00:00",
//	"product_updated_at":"2020-11-11T11:02:40.000+00:00"}


public class Product {
	private Integer product_id;
	private String product_name;
	private String product_desc;
	private String image;
	private String imageType;
	private SubCategory subCategory;
	private Integer product_price;
	
	public Product() {
		
	}
	public Product(Integer product_id, String product_name, String product_description, SubCategory subCategory,
			Integer product_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_desc = product_description;
		this.subCategory = subCategory;
		this.product_price = product_price;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_description(String product_description) {
		this.product_desc = product_description;
	}
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	public Integer getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_description="
				+ product_desc + ", subCategory=" + subCategory + ", product_price=" + product_price + "]";
	}
	
}
