package com.reviewdekho.report.model;

import java.sql.Timestamp;

import com.reviewdekho.comment.model.Comment;
import com.reviewdekho.review.model.Review;
import com.reviewdekho.user.model.User;

public class Report {
	private Integer report_id;
	private Review review;
	private Comment comment;
	private User user;
	private String report_description;
	private Boolean report_status;
	private Timestamp report_created_at;
	private Timestamp report_updated_at;
	
	public Report() {
		
	}
	
	public Integer getReport_id() {
		return report_id;
	}
	public void setReport_id(Integer report_id) {
		this.report_id = report_id;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Timestamp getReport_created_at() {
		return report_created_at;
	}
	public void setReport_created_at(Timestamp report_created_at) {
		this.report_created_at = report_created_at;
	}
	public Timestamp getReport_updated_at() {
		return report_updated_at;
	}
	public void setReport_updated_at(Timestamp report_updated_at) {
		this.report_updated_at = report_updated_at;
	}

	public String getReport_descrption() {
		return report_description;
	}

	public void setReport_descrption(String report_descrption) {
		this.report_description = report_descrption;
	}

	public Boolean getReport_status() {
		return report_status;
	}

	public void setReport_status(Boolean report_status) {
		this.report_status = report_status;
	}
	
}
