package com.reviewdekho.user.model;

import java.sql.Timestamp;

public class User {
	private Integer user_id;
	private String email_id;
	private String user_name;
	private String password;
	private String profileImage;
	private String imageType;
	private Integer user_role;
	private Timestamp user_created_at;
	private Timestamp user_updated_at;
	
	public User() { }

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUser_role() {
		return user_role;
	}

	public void setUser_role(Integer user_role) {
		this.user_role = user_role;
	}

	public Timestamp getUser_created_at() {
		return user_created_at;
	}

	public void setUser_created_at(Timestamp user_created_at) {
		this.user_created_at = user_created_at;
	}

	public Timestamp getUser_updated_at() {
		return user_updated_at;
	}

	public void setUser_updated_at(Timestamp user_updated_at) {
		this.user_updated_at = user_updated_at;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
}
