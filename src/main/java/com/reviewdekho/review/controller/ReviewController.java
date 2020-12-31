package com.reviewdekho.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reviewdekho.product.model.Product;
import com.reviewdekho.product.service.ProductService;
import com.reviewdekho.review.model.Review;
import com.reviewdekho.review.service.ReviewService;
import com.reviewdekho.subcategory.model.SubCategory;
import com.reviewdekho.user.model.User;
import com.reviewdekho.user.service.UserService;

@WebServlet("/review")
public class ReviewController extends HttpServlet {

	private ReviewService reviewService;
	private UserService userService;
	private ProductService productService;
	HttpSession session;
	
	@Override
	public void init() throws ServletException {
		reviewService = new ReviewService();
		userService = new UserService();
		productService = new ProductService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From Get ReviewController");
		session = request.getSession();
		if( request.getParameter( "update" ) != null ) {
			Integer reviewId = Integer.parseInt( request.getParameter( "update" ));
			
			Review review = reviewService.get(reviewId);
			List< Product > products = productService.get();
			// TODO get user list 
			List< User > users = userService.get();
			
			System.out.println(reviewId);
			
			session.setAttribute( "review", review );
			session.setAttribute( "products", products );
			session.setAttribute( "users", users );
			
			response.sendRedirect( "views/Admin/Review/edit-review.jsp" );
		}
		
		else if( request.getParameter( "add" ) != null ) {
			Integer reviewId = Integer.parseInt( request.getParameter( "add" ));
			
			Review review = reviewService.get(reviewId);
			List< Product > products = productService.get();
			// TODO get user list 
			List< User > users = userService.get();
			
			response.sendRedirect( "views/Admin/Review/add-review.jsp" );
		}
		
		else if( request.getParameter( "delete" ) != null ) {
			doDelete( request, response ); 
		}
		
		else if( request.getParameter( "delete" ) == null && request.getParameter( "update" ) == null ) {
			getAllReviews(response);
		}
	}

	private void getAllReviews(HttpServletResponse response) throws IOException {
		List< Review > reviews = reviewService.get();
		session.setAttribute( "reviews", reviews );
		response.sendRedirect( "views/Admin/Review/Reviews.jsp" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		
		if( request.getParameter( "reviewId" ) != null ) {
//			do iff we want to update review !!!
			doPut( request, response );
			return;
		}
		
		Integer userId = Integer.parseInt( request.getParameter( "user" ) );
		Integer productId = Integer.parseInt( request.getParameter( "product" ) );
		
		Review review = new Review();
		review.setReview_desc( request.getParameter( "reviewDesc" ) );
		
		User user = new User();
		user.setUser_id(userId);
		
		Product product = new Product();
		product.setProduct_id( productId );
		
		review.setProduct(product);
		review.setUser(user);
		
		reviewService.add(review);
		
		getAllReviews(response);
	}

	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer reviewId = Integer.parseInt( req.getParameter( "delete" ) );
		reviewService.delete(reviewId);
		getAllReviews(resp);
	}
}
