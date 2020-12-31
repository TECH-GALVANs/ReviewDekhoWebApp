package com.reviewdekho.model;

public class Category {
	private int categoryId;
	private String categoryName;
	
	public Category() {}
	
	public Category( final int categoryId, final String categoryName ) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}

