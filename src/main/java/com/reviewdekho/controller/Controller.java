package com.reviewdekho.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.reviewdekho.model.Category;

//@WebServlet("/category")
public class Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if( request.getParameter( "update" ) != null) {
			System.out.println("From doGet if...");
			System.out.println(request.getParameter("update"));
			getDataBYId( request, response );
		}
		else if( request.getParameter( "delete" ) != null ) {
			System.out.println("From doget else-if delete : "+ request.getParameter( "delete" ));
			doDelete( request, response );
		}
		else {
			System.out.println("From doget else");
			getData( request, response );
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From delete..." + request.getParameter( "delete" ) );
		int category_id = Integer.parseInt( request.getParameter( "delete" ) );
		URL url = new URL( "http://localhost:8080/api/category/"+category_id );
		
		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "DELETE" );
		postReq.setRequestProperty( "Content-Type", "application/json" );

		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
		
		response.sendRedirect( "views/index.jsp" );
	}
	
	private void getData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = "http://localhost:8080/api/category";
		
		HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse resp = null;
		try {
			resp = client.send( req, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		
		JSONArray array = new JSONArray(resp.body().toString());
		List<Category> categories = new ArrayList<Category>();
			
		for( int i = 0; i < array.length(); i++ ) {
			JSONObject object = array.getJSONObject(i);
			Category category = new Category();
			category.setCategoryId( object.getInt( "category_id" ) );
			category.setCategoryName( object.getString( "category_name" ) );
			System.out.println(object.getString("category_name"));
			categories.add(category);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("categories", categories );
		
		response.sendRedirect("views/Category.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if( request.getParameter( "categoryId" ) != null ) {
			System.out.println("From post if");
			doPut( request, response );
		} else {
			addCategory( request, response );
			
		}
		
	}
	
	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("From post..."+request.getParameter("categoryName"));
		//		String url = "http://localhost:8080/api/category";
		URL url = new URL( "http://localhost:8080/api/category" );
		
		final String cats = "{\n " + "\"category_name\": "+request.getParameter("categoryName")+" \n}";
		
		HashMap<String, String> body = new HashMap<String, String>();
		
		body.put( "category_name", request.getParameter( "categoryName" ) );
		
		System.out.println(body.toString());
		
		JSONObject category = new JSONObject( cats );
		
//		category.append( "category_name", request.getParameter( "categoryName" ) );
		
		String requestBody = category.toString();
		
		System.out.println(requestBody);
//		
//		 HttpClient client = HttpClient.newHttpClient();
//	     HttpRequest req = HttpRequest.newBuilder()
//	                .uri(URI.create("http://localhost:8080/api/category"))
//	                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//	                .build();
//	     
//	     
//	     HttpResponse<String> resp = null;
//		try {
//			resp = client.send(req ,
//			            HttpResponse.BodyHandlers.ofString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	        System.out.println(resp.body());
		
		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "POST" );
		postReq.setRequestProperty( "Content-Type", "application/json" );
		
		postReq.setDoOutput( true );
		OutputStream os = postReq.getOutputStream();
		os.write( requestBody.getBytes() );
		os.flush();
		os.close();
		
		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
		
		doGet( request, response );
		
	}

	private void getDataBYId( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		 int category_id = Integer.parseInt( request.getParameter( "update" ) );
		 
		 String url = "http://localhost:8080/api/category/"+category_id;
			
			HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
			
			HttpClient client = HttpClient.newBuilder().build();
			HttpResponse resp = null;
			try {
				resp = client.send( req, HttpResponse.BodyHandlers.ofString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(resp.statusCode());
			System.out.println(resp.body());
			
			JSONObject object = new JSONObject( resp.body().toString() );
			
			Category category = new Category();
			
			category.setCategoryId( object.getInt( "category_id" ) );
			category.setCategoryName( object.getString( "category_name" ) );
			
			System.out.println(category.getCategoryId() +" "+category.getCategoryName());
			
			HttpSession session = request.getSession();
			session.setAttribute( "category", category );
			
			response.sendRedirect( "views/edit-category.jsp" );
	 }

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		System.out.println("From put..."+request.getParameter("categoryName") + " " + request.getParameter( "categoryId" ) );
		int category_id = Integer.parseInt( request.getParameter( "categoryId" ) );
		URL url = new URL( "http://localhost:8080/api/category/"+category_id );
		
		final String cats = "{\n " + "\"category_name\": "+request.getParameter("categoryName")+" \n}";
		
		HashMap<String, String> body = new HashMap<String, String>();
		
		body.put( "category_name", request.getParameter( "categoryName" ) );
		
		System.out.println(body.toString());
		
		JSONObject category = new JSONObject( cats );
				
		String requestBody = category.toString();
		
		System.out.println(requestBody);
		
		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "PUT" );
		postReq.setRequestProperty( "Content-Type", "application/json" );
		
		postReq.setDoOutput( true );
		OutputStream os = postReq.getOutputStream();
		os.write( requestBody.getBytes() );
		os.flush();
		os.close();
		
		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
		
		response.sendRedirect( "views/index.jsp" );
//		doGet( request, response );
	}
}
