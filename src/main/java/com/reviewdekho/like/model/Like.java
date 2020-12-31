package com.reviewdekho.like.model;

import java.sql.Timestamp;

import com.reviewdekho.review.model.Review;
import com.reviewdekho.user.model.User;

public class Like {
	private Integer like_id;
	private Review review;
	private User user;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Boolean isLiked;
	
	public Like() {
		
	}

	public Integer getLike_id() {
		return like_id;
	}

	public void setLike_id(Integer like_id) {
		this.like_id = like_id;
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

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public Boolean getIs_liked() {
		return isLiked;
	}

	public void setIs_liked(Boolean is_liked) {
		this.isLiked = is_liked;
	}
}
