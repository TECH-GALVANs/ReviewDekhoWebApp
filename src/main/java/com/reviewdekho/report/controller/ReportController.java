package com.reviewdekho.report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reviewdekho.like.model.Like;
import com.reviewdekho.report.model.Report;
import com.reviewdekho.report.service.ReportService;
import com.reviewdekho.review.model.Review;
import com.reviewdekho.review.service.ReviewService;
import com.reviewdekho.user.model.User;

@WebServlet("/report")
public class ReportController extends HttpServlet {

	private ReviewService reviewService;
	private ReportService reportService;
	
	HttpSession session;
	
	@Override
	public void init() throws ServletException {
		reviewService = new ReviewService();
		reportService = new ReportService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From Get ReportController");
		session = request.getSession();
		if( request.getParameter( "update" ) != null ) {
			Integer reportId = Integer.parseInt( request.getParameter( "update" ));
			
//			Do code on updating the status of report.
			
//			This is for adding report.....
//			Review review = new Review();
//			review.setReview_id( Integer.parseInt( request.getParameter( "reviewId" ) ));
//			
//			User user = new User();
//			user.setUser_id( Integer.parseInt( request.getParameter( "userId" ) ) );
//			
//			Report report = new Report();
//			report.setReview(review);
//			report.setReport_descrption( request.getParameter( "reportDescription" ));
//			report.setUser(user);
			
			response.sendRedirect( "views/Admin/Like/edit-like.jsp" );
		}
		
		else if( request.getParameter( "add" ) != null ) {
			Integer likeId = Integer.parseInt( request.getParameter( "add" ));
			
//			TODO What to do for Report adding !!
			
//			response.sendRedirect( "views/Admin/Review/add-review.jsp" );
		}
		
		else if( request.getParameter( "delete" ) != null ) {
			doDelete( request, response ); 
		}
		
		else if( request.getParameter( "delete" ) == null && request.getParameter( "update" ) == null ) {
			getAllReports(response);
		}
	}

	private void getAllReports(HttpServletResponse response) throws IOException {
		List< Report > reports = reportService.get();
		
		session.setAttribute( "reports", reports );
		
		response.sendRedirect( "views/Admin/Report/Reports.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
