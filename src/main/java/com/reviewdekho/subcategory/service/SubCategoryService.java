package com.reviewdekho.subcategory.service;

import java.io.IOException;
import java.util.List;

import com.reviewdekho.subcategory.dao.SubCategoryDao;
import com.reviewdekho.subcategory.model.SubCategory;

public class SubCategoryService {

		private SubCategoryDao dao;
		
		public SubCategoryService() {
			dao = new SubCategoryDao();
		}
	
		public void add( SubCategory subCategory ) throws IOException {
			dao.addSubCategory( subCategory );
		}
		
		public List<SubCategory> get(){
			return dao.getSubCategory();
		}
		
		public SubCategory getById( Integer subCategoryId ) {
			return dao.getSubCategory(subCategoryId);
		}
		
		public void update( Integer subCategoryId, SubCategory subCategory ) throws IOException {
			dao.updateSubCategory(subCategoryId, subCategory);
		}
		
		public void delete( Integer subCategoryId ) throws IOException {
			dao.deleteSubCategory(subCategoryId);
		}
}
