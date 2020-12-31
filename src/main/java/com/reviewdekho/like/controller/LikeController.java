package com.reviewdekho.like.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reviewdekho.like.model.Like;
import com.reviewdekho.like.service.LikeService;
import com.reviewdekho.product.model.Product;
import com.reviewdekho.review.model.Review;
import com.reviewdekho.review.service.ReviewService;
import com.reviewdekho.user.model.User;
import com.reviewdekho.user.service.UserService;

//@WebServlet( "/like" )
public class LikeController extends HttpServlet {
	private LikeService likeService;
	private UserService userService;
	private ReviewService reviewService;
	
	HttpSession session;
	
	@Override
	public void init() throws ServletException {
		likeService = new LikeService();
		userService = new UserService();
		reviewService = new ReviewService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From Get LikeController");
		session = request.getSession();
		
		if( request.getParameter( "user" ) != null && request.getParameter( "review" ) != null ) {
			Review review = new Review();
			review.setReview_id( Integer.parseInt( request.getParameter( "review" ) ) );
			
			User user = new User();
			user.setUser_id( Integer.parseInt( request.getParameter( "user" ) ) );
			
			Like like = new Like();
			like.setUser(user);
			like.setReview(review);
			
			likeService.add(like);
			
			response.sendRedirect( "views/User/index.jsp" );
		}
		
		else if( request.getParameter( "user" ) != null && request.getParameter( "reviewId" ) != null ) {
			Review review = new Review();
			review.setReview_id( Integer.parseInt( request.getParameter( "reviewId" ) ) );
			
			User user = new User();
			user.setUser_id( Integer.parseInt( request.getParameter( "user" ) ) );
			
			Like like = new Like();
			like.setUser(user);
			like.setReview(review);
			
			likeService.add(like);
			
			response.sendRedirect( "views/User/Review-detail.jsp?reviewId="+review.getReview_id() );
		}
		
		else if( request.getParameter( "delete" ) == null && request.getParameter( "update" ) == null ) {
			getAllLikes(response);
		}
	}

	private void getAllLikes(HttpServletResponse response) throws IOException {
		List< Like > likes = likeService.get();
		
		session.setAttribute( "likes", likes );
		
		response.sendRedirect( "views/Admin/Like/Likes.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
