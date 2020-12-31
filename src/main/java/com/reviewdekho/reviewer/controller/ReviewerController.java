package com.reviewdekho.reviewer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reviewdekho.reviewer.model.Reviewer;
import com.reviewdekho.reviewer.service.ReviewerService;

@WebServlet("/reviewer")
public class ReviewerController extends HttpServlet {

	private ReviewerService reviewerService;
	HttpSession session;
	
	@Override
	public void init() throws ServletException {
		reviewerService = new ReviewerService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		
		if ( request.getParameter( "status" ) == null ) {
			List<Reviewer> reviewers = reviewerService.get();
			session.setAttribute( "reviewers", reviewers );
			response.sendRedirect( "views/Admin/Reviewer/Reviewer-Requests.jsp");
		}
				
		if( request.getParameter( "status" ) != null && request.getParameter( "reviewerId" ) != null ) {
			Integer reviewerId = Integer.parseInt( request.getParameter( "reviewerId" ) );
			Integer status = Integer.parseInt( request.getParameter( "status" ) );
			
			System.out.println( reviewerId );
			System.out.println(status);
			
			reviewerService.update( reviewerId, status);
			List<Reviewer> reviewers = reviewerService.get();
			session.setAttribute( "reviewers", reviewers );
			response.sendRedirect( "views/Admin/Reviewer/Reviewer-Requests.jsp");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
