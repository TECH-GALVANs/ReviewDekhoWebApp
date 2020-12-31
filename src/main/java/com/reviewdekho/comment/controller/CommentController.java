package com.reviewdekho.comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reviewdekho.comment.model.Comment;
import com.reviewdekho.comment.service.CommentService;
import com.reviewdekho.review.model.Review;
import com.reviewdekho.review.service.ReviewService;
import com.reviewdekho.user.model.User;
import com.reviewdekho.user.service.UserService;

@WebServlet("/comment")
public class CommentController extends HttpServlet {

	private CommentService commentService;
	private ReviewService reviewService;
	private UserService userService;
	
	HttpSession session;
	
	@Override
	public void init() throws ServletException {
		commentService = new CommentService();
		reviewService = new ReviewService();
		userService = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From Get ReportController");
		session = request.getSession();
		if( request.getParameter( "update" ) != null ) {
			Integer reportId = Integer.parseInt( request.getParameter( "update" ));
			
//			TODO Do code on updating the status of report.
						
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
			getAllComments(response);
		}
	}

	private void getAllComments(HttpServletResponse response) throws IOException {
		List<Comment> comments = commentService.get();
		session.setAttribute( "comments", comments );
		response.sendRedirect( "views/Admin/Comment/Comments.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment = request.getParameter( "comment" );
		Integer userId = Integer.parseInt( request.getParameter( "user" )  );
		Integer reviewId = Integer.parseInt( request.getParameter( "review" )  );
	
		User user = new User();
		user.setUser_id(userId);
		
		Review review = new Review();
		review.setReview_id(reviewId);
		
		Comment commentObj = new Comment();
		commentObj.setReview(review);
		commentObj.setUser(user);
		commentObj.setComment_desc(comment);
		
		commentService.add(commentObj);
		
		response.sendRedirect( "views/User/Review-detail.jsp?reviewId="+reviewId );
		
	}

}
