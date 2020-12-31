package com.reviewdekho.user.dao;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.reviewdekho.product.model.Product;
import com.reviewdekho.user.model.User;

public class UserDao implements UserDaoI {

	public void add(User user) throws IOException {
		URL url = new URL( "http://localhost:8080/api/user" );
		
		JSONObject userJson = new JSONObject();
		userJson.put( "user_name", user.getUser_name() );
		userJson.put( "email_id", user.getEmail_id() );
		userJson.put( "password", user.getPassword() );
		userJson.put( "profileImage", user.getProfileImage());
		userJson.put( "imageType", user.getImageType() );
		
		String requestBody = userJson.toString();
		
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

	public List<User> get() {
		String url = "http://localhost:8080/api/user";
		
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
		Type usersListType = new TypeToken< List< User > >() {}.getType();
		List<User> users = gson.fromJson( resp.body().toString(), usersListType );
		System.out.println(users.get(0).getEmail_id());
		
		return users;
	}

	public User get(Integer userId) {
		String url = "http://localhost:8080/api/user/"+userId;
		
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
		User user = gson.fromJson( resp.body().toString(), User.class );
		return user;
	}

	public void update(Integer userId, User user) throws IOException {
		URL url = new URL( "http://localhost:8080/api/user/" + userId );
		
		JSONObject userJson = new JSONObject();
		userJson.put( "user_name", user.getUser_name() );
		userJson.put( "emailid", user.getEmail_id() );
		
		String requestBody = userJson.toString();
		
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
	}

	public void delete(Integer userId) throws IOException {
		URL url = new URL( "http://localhost:8080/api/user/"+userId );
		
		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "DELETE" );
		postReq.setRequestProperty( "Content-Type", "application/json" );

		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
	}
	
	public User signUp( User userS ) throws IOException {
		String url = "http://localhost:8080/api/user/emailid/"+userS.getEmail_id();
		
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
		User user = gson.fromJson( resp.body().toString(), User.class );
		
		if( user == null ) {
			return null;
		}
		
		else if( user.getEmail_id().equals( userS.getEmail_id() )  && user.getPassword().equals( userS.getPassword() )){
			return user;
		}
		
		return null;
	}

}
