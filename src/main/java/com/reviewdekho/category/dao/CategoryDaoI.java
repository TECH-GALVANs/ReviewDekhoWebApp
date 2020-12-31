package com.reviewdekho.category.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.category.model.Category;

public interface CategoryDaoI {
	void addCategory( Category category ) throws MalformedURLException, IOException;
	List< Category > getCategory();
	Category getCategory( final Integer categoryId );
	void updateCategory( final Integer categoryId, Category category ) throws IOException;
	void deleteCategory( final Integer categoryId ) throws IOException;
}
