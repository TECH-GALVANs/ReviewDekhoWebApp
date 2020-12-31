package com.reviewdekho.subcategory.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reviewdekho.category.model.Category;
import com.reviewdekho.category.service.CategoryService;
import com.reviewdekho.subcategory.model.SubCategory;
import com.reviewdekho.subcategory.service.SubCategoryService;

@WebServlet("/sub-category")
public class SubCategoryController extends HttpServlet {

	SubCategoryService service;
	CategoryService categoryService;
	HttpSession session;
	
	@Override
	public void init() throws ServletException {
		service = new SubCategoryService();
		categoryService = new CategoryService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		session = request.getSession();
		if( request.getParameter( "update" ) != null ) {
			Integer subCategoryId = Integer.parseInt( request.getParameter( "update" ));
			
			SubCategory subCategory = service.getById(subCategoryId);
			List< Category > categories = categoryService.get();
			
			System.out.println(subCategoryId);
			System.out.println(subCategory.getSub_category_name());
			
			session.setAttribute( "sub-category", subCategory );
			session.setAttribute("categories", categories);
			
			response.sendRedirect( "views/Admin/Sub-category/edit-sub-category.jsp" );
			
		}
		
		else if( request.getParameter( "add" ) != null ) {
			List< Category > categories = categoryService.get();
			session.setAttribute("categories", categories);
			response.sendRedirect( "views/Admin/Sub-category/add-sub-category.jsp" );
			
		}
		
		else if( request.getParameter( "delete" ) != null ) {
			doDelete( request, response ); 
		}
		
		else if( request.getParameter( "delete" ) == null && request.getParameter( "update" ) == null ) {
			getAllSubCategories(response);
		}
	}
	
	private void getAllSubCategories( HttpServletResponse response ) throws IOException {
		List<SubCategory> subCategories = service.get();
		
		session.setAttribute("subCategories", subCategories );
		
		response.sendRedirect( "views/Admin/Sub-category/sub-category.jsp" );
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if( request.getParameter( "subCategoryId" ) != null ) {
			doPut( request, response );
			return;
		}
		
		Integer categoryId = Integer.parseInt( request.getParameter( "category" ) );
		
		SubCategory subCategory = new SubCategory();
		Category category = new Category();
		category.setCategory_id(categoryId);
		subCategory.setCategory( category );
		subCategory.setSub_category_name( request.getParameter( "subCategoryName" ) );
		
		service.add(subCategory);
		
		getAllSubCategories(response);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Integer subCategoryId = Integer.parseInt( request.getParameter( "delete" ));
		
		service.delete(subCategoryId);
		
		getAllSubCategories( response );
	
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		SubCategory subCategory = new SubCategory();
		
		subCategory.setSub_category_id( Integer.parseInt( request.getParameter( "subCategoryId" ) ) );
		subCategory.setSub_category_name( request.getParameter( "subCategoryName" ) );
		
		service.update( subCategory.getSub_category_id(), subCategory);
		
		getAllSubCategories(response);
		
	}
}


