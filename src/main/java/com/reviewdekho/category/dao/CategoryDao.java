package com.reviewdekho.category.dao;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.reviewdekho.category.model.Category;
import com.reviewdekho.subcategory.model.SubCategory;

public class CategoryDao implements CategoryDaoI {

	public void addCategory(Category category) throws IOException {
		URL url = new URL( "http://localhost:8080/api/category" );
		
		final String cats = "{\n " + "\"category_name\": "+category.getCategory_name()+" \n}";

		JSONObject categoryJson = new JSONObject( cats );
		
		String requestBody = categoryJson.toString();
		
		System.out.println(requestBody);

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
		
	}

	public List<Category> getCategory() {
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
		
		Gson gson = new Gson();
		Type categoryListType = new TypeToken< List< Category > >() {}.getType();
		List<Category> categories = gson.fromJson( resp.body().toString(), categoryListType );
		return categories;
	}

	public Category getCategory(Integer categoryId) {
		String url = "http://localhost:8080/api/category/"+categoryId;
			
		HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
			
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse resp = null;
		try {
			resp = client.send( req, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
			
		Gson gson = new Gson();
		Category category = gson.fromJson( resp.body().toString(), Category.class );
		return category;
	}

	public void updateCategory(Integer categoryId, Category category) throws IOException {
		URL url = new URL( "http://localhost:8080/api/category/"+categoryId );
		
		final String cats = "{\n " + "\"category_name\": "+category.getCategory_name()+" \n}";

		JSONObject categoryJson = new JSONObject( cats );
		
		String requestBody = categoryJson.toString();
		
		HttpURLConnection postReq = null;
		try {
			postReq = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		postReq.setRequestMethod( "PUT" );
		postReq.setRequestProperty( "Content-Type", "application/json" );
		
		postReq.setDoOutput( true );
		OutputStream os = postReq.getOutputStream();
		os.write( requestBody.getBytes() );
		os.flush();
		os.close();
		
		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
		
	}

	public void deleteCategory(Integer categoryId) throws IOException {
		URL url = new URL( "http://localhost:8080/api/category/"+categoryId );
		
		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "DELETE" );
		postReq.setRequestProperty( "Content-Type", "application/json" );

		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
		
	}

}
