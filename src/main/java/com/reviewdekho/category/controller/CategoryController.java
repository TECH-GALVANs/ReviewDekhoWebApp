package com.reviewdekho.category.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reviewdekho.category.model.Category;
import com.reviewdekho.category.service.CategoryService;

@WebServlet("/category")
public class CategoryController extends HttpServlet {
//	phenomenon
//	noumenon
	CategoryService service;
	HttpSession session;
	
	@Override
	public void init() throws ServletException {
		service = new CategoryService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		
		if( request.getParameter( "update" ) != null ) {
			Integer categoryId = Integer.parseInt( request.getParameter( "update" ));
			
			Category category = service.get(categoryId);
			
			System.out.println(categoryId);
			System.out.println(category.getCategory_name());
			
			session.setAttribute( "category", category );
			
			response.sendRedirect( "views/Admin/Category/edit-category.jsp" );
			
		}
		
		else if( request.getParameter( "delete" ) != null ) {
			doDelete( request, response ); 
		}
		
		else if( request.getParameter( "delete" ) == null && request.getParameter( "update" ) == null ) {
			getAllCategories(response);
		}
	}
	
	private void getAllCategories( HttpServletResponse response ) throws IOException {
		List<Category> categories = service.get();
		
		session.setAttribute("categories", categories );
		
		response.sendRedirect( "views/Admin/Category/Category.jsp" );
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		session = request.getSession();
		if( request.getParameter( "categoryId" ) != null ) {
			doPut( request, response );
			return;
		}
		
		Category category = new Category();
		
		category.setCategory_name( request.getParameter( "categoryName" ) );
		
		service.add(category);
		
		getAllCategories(response);
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer categoryId = Integer.parseInt( request.getParameter( "delete" ));
		
		service.delete(categoryId);
		
		getAllCategories( response );
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Category category = new Category();
		
		category.setCategory_id( Integer.parseInt( request.getParameter( "categoryId" ) ) );
		category.setCategory_name( request.getParameter( "categoryName" ) );
		
		service.update( category.getCategory_id(), category);
		
		getAllCategories(response);
	}
}
