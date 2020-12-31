package com.reviewdekho.category.service;

import java.io.IOException;
import java.util.List;

import com.reviewdekho.category.dao.CategoryDao;
import com.reviewdekho.category.model.Category;

public class CategoryService {
	
	private CategoryDao dao;
	
	public CategoryService() {
		dao = new CategoryDao();
	}
	
	public void add( Category category ) throws IOException {
		dao.addCategory( category );
	}
	
	public List<Category> get(){
		return dao.getCategory();
	}
	
	public Category get( Integer categoryId ) {
		return dao.getCategory( categoryId );
	}
	
	public void update( Integer categoryId, Category category ) throws IOException {
		dao.updateCategory(categoryId, category);
	}
	
	public void delete( Integer categoryId ) throws IOException {
		dao.deleteCategory(categoryId);
	}
}
