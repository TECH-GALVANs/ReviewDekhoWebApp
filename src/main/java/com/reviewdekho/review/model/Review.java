package com.reviewdekho.review.model;

import java.sql.Timestamp;

import com.reviewdekho.product.model.Product;
import com.reviewdekho.user.model.User;

public class Review {
	private Integer review_id;
	private String review_desc;
	private User user;
	private Product product;
	private Timestamp review_added_at;
	private Timestamp review_updated_at;
	
	public Review() {
		
	}
	
	public Integer getReview_id() {
		return review_id;
	}
	public void setReview_id(Integer review_id) {
		this.review_id = review_id;
	}
	public String getReview_desc() {
		return review_desc;
	}
	public void setReview_desc(String review_desc) {
		this.review_desc = review_desc;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Timestamp getReview_added_at() {
		return review_added_at;
	}
	public void setReview_added_at(Timestamp review_added_at) {
		this.review_added_at = review_added_at;
	}
	public Timestamp getReview_updated_at() {
		return review_updated_at;
	}
	public void setReview_updated_at(Timestamp review_updated_at) {
		this.review_updated_at = review_updated_at;
	}
}
