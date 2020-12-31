package com.reviewdekho.comment.model;

import java.sql.Timestamp;

import com.reviewdekho.review.model.Review;
import com.reviewdekho.user.model.User;

public class Comment {
	private Integer comment_id;
	private String comment_desc;
	private Review review;
	private User user;
	private Timestamp comment_created_at;
	private Timestamp comment_updated_at;
	private Boolean is_deleted;
	
	public Comment() {
		
	}
	
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment_desc() {
		return comment_desc;
	}
	public void setComment_desc(String comment_desc) {
		this.comment_desc = comment_desc;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Timestamp getComment_created_at() {
		return comment_created_at;
	}
	public void setComment_created_at(Timestamp comment_created_at) {
		this.comment_created_at = comment_created_at;
	}
	public Timestamp getComment_updated_at() {
		return comment_updated_at;
	}
	public void setComment_updated_at(Timestamp comment_updated_at) {
		this.comment_updated_at = comment_updated_at;
	}
	public Boolean getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(Boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
}
