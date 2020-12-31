package com.reviewdekho.image.model;

import java.sql.Blob;
import java.sql.Timestamp;

import com.reviewdekho.product.model.Product;

public class ProductImage {
	private Integer image_id;
	private String image;
	private Product product;
	private Timestamp image_created_at;
	private Timestamp image_updated_at;

	public ProductImage() {
		
	}
	
	public Integer getImage_id() {
		return image_id;
	}
	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Timestamp getImage_created_at() {
		return image_created_at;
	}
	public void setImage_created_at(Timestamp image_created_at) {
		this.image_created_at = image_created_at;
	}
	public Timestamp getImage_updated_at() {
		return image_updated_at;
	}
	public void setImage_updated_at(Timestamp image_updated_at) {
		this.image_updated_at = image_updated_at;
	}
}
