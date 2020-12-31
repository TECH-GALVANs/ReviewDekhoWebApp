package com.reviewdekho.user.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.reviewdekho.user.model.User;
import com.reviewdekho.user.service.UserService;

@WebServlet( "/user" )
@MultipartConfig
public class UserController extends HttpServlet {
	
	private UserService userService;
	HttpSession session;
	
    public void init() throws ServletException {
    	userService = new UserService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From Get ProductController");
		session = request.getSession();
		if( request.getParameter( "update" ) != null ) {
			Integer userId = Integer.parseInt( request.getParameter( "update" ));
			
			User user = userService.get( userId );
			
			System.out.println(userId);
			System.out.println(user.getEmail_id());
			
			session.setAttribute( "user", user );
			
			response.sendRedirect( "views/User/edit-user.jsp" );
			
		}
		
		else if( request.getParameter( "add" ) != null ) {
//			List< SubCategory > subCategories = subCategoryService.get();
//			session.setAttribute("subCategories", subCategories);
			getAllUsers(response);
			
		}
		
		else if( request.getParameter( "delete" ) != null ) {
			doDelete( request, response ); 
		}
		
		else if( request.getParameter( "signout" ) != null ) {
			System.out.println( "Sinout" + request.getParameter( "signout" ));
			Integer userId = Integer.parseInt( request.getParameter( "signout" ) );
			session.removeAttribute( "user" );
			response.sendRedirect( "views/User/index.jsp" );
		}
		
		else if( request.getParameter( "delete" ) == null && request.getParameter( "update" ) == null ) {
			getAllUsers(response);
		}
		
	}

	private void getAllUsers(HttpServletResponse response) throws IOException {
		List< User > users = userService.get();
		session.setAttribute( "users", users );
		response.sendRedirect( "views/Admin/user/Users.jsp" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println( "post" );
		session = request.getSession();
		
		if( request.getParameter( "userId" ) != null ) {
			System.out.println( "update-post" );
			doPut( request, response );
			return;
		}
		
		if( request.getParameter( "signup" ) != null  ) {
			System.out.println( "signup-post" );
			Part imagePart = request.getPart( "profilePicture" );
			InputStream image = imagePart.getInputStream();
			byte[] imageBytes = new byte[ image.available() ];
			String base64Image = Base64.getEncoder().encodeToString( image.readAllBytes() );
			String imageType = imagePart.getContentType().substring(imagePart.getContentType().indexOf( "/" ) + 1 );
			
			User user = new User();
			user.setEmail_id( request.getParameter( "emailId" ) );
			user.setUser_name( request.getParameter( "userName" ) );
			user.setPassword( request.getParameter( "password" ) );
			user.setProfileImage(base64Image);
			user.setImageType( imageType );
			
//			System.out.println( imageType );
			System.out.println(user.getUser_name());
			
			userService.add( user );
			
			session.setAttribute( "user", user);
			
			response.sendRedirect( "views/User/index.jsp" );
		}
		
		if( request.getParameter( "signin" ) != null ) {
			System.out.println( request.getParameter( "signin" ) );
			String emailId = request.getParameter( "emailId" );
			String password = request.getParameter( "password" );
			
			if( emailId == null || password == null ) {
				session.setAttribute( "message", "Please enter proper emailId or password !!!" );
				response.sendRedirect( "views/User/Sign-in.jsp" );
			}
			
			User user = new User();
			user.setEmail_id( emailId );
			user.setPassword( password );
			
			System.out.println( request.getParameter( "emailId" ) );
			System.out.println( request.getParameter( "password" ) );
			
			User userA = userService.signUp( user );
			
			if( userA ==  null  ) {
				session.setAttribute( "message", "Email-id or password doesn't match !!!" );
				response.sendRedirect( "views/User/Sign-in.jsp" );
			} else {	
				session.setAttribute( "user" , userA );
				session.setMaxInactiveInterval( 60 * 60 );
				
				if( userA.getUser_role() == 2 )
					response.sendRedirect( "views/Admin/index.jsp" );
				else
					response.sendRedirect( "views/User/index.jsp" );
			}
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}
