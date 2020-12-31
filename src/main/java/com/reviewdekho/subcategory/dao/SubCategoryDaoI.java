package com.reviewdekho.subcategory.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.subcategory.model.SubCategory;


public interface SubCategoryDaoI {
	void addSubCategory( SubCategory subCategory ) throws MalformedURLException, IOException;
	List< SubCategory > getSubCategory();
	SubCategory getSubCategory( final Integer subCategoryId );
	void updateSubCategory( final Integer SubCategoryId, SubCategory subCategory ) throws IOException;
	void deleteSubCategory( final Integer subCategoryId ) throws IOException;
}
