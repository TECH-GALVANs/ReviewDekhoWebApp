package com.reviewdekho.reviewer.model;

import java.sql.Timestamp;

import com.reviewdekho.user.model.User;

public class Reviewer {
	private Integer reviewer_id;
	private User user;
	private String reviewer_description;
	private Integer reviewer_status;
	private Timestamp request_created_at;
	private Timestamp request_updated_at;
	
	public Reviewer() {
		
	}
	
	public Reviewer(Integer reviewer_id, User user, String reviewer_description, Integer reviewer_status,
			Timestamp request_created_at, Timestamp request_updated_at) {
		super();
		this.reviewer_id = reviewer_id;
		this.user = user;
		this.reviewer_description = reviewer_description;
		this.reviewer_status = reviewer_status;
		this.request_created_at = request_created_at;
		this.request_updated_at = request_updated_at;
	}
	public Integer getReviewer_id() {
		return reviewer_id;
	}
	public void setReviewer_id(Integer reviewer_id) {
		this.reviewer_id = reviewer_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getReviewer_description() {
		return reviewer_description;
	}
	public void setReviewer_description(String reviewer_description) {
		this.reviewer_description = reviewer_description;
	}
	public Integer getReviewer_status() {
		return reviewer_status;
	}
	public void setReviewer_status(Integer reviewer_status) {
		this.reviewer_status = reviewer_status;
	}
	public Timestamp getRequest_created_at() {
		return request_created_at;
	}
	public void setRequest_created_at(Timestamp request_created_at) {
		this.request_created_at = request_created_at;
	}
	public Timestamp getRequest_updated_at() {
		return request_updated_at;
	}
	public void setRequest_updated_at(Timestamp request_updated_at) {
		this.request_updated_at = request_updated_at;
	}
}	
