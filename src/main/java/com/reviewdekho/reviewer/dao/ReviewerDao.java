package com.reviewdekho.reviewer.dao;

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
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.reviewdekho.product.model.Product;
import com.reviewdekho.reviewer.model.Reviewer;

public class ReviewerDao implements ReviewerDaoI {

	public void add(Reviewer reviewer) throws MalformedURLException, IOException {
		URL url = new URL( "http://localhost:8080/api/reviewer" );
	
		JSONObject userJson = new JSONObject();
		userJson.put( "user_id", reviewer.getUser().getUser_id() );

		JSONObject reviewerJson = new JSONObject();
		reviewerJson.put( "reviewer_description", reviewer.getReviewer_description() );
		reviewerJson.put( "user", userJson );		
		
		String requestBody = reviewerJson.toString();
		
//		System.out.println(requestBody);

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

	public List<Reviewer> get() {
		String url = "http://localhost:8080/api/reviewer";
		
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
//		
		Gson gson = new Gson();
		Type reviewerListType = new TypeToken< List< Reviewer > >() {}.getType();
		List<Reviewer> reviewers = gson.fromJson( resp.body().toString(), reviewerListType );
		System.out.println(reviewers.get(0).getReviewer_description());
		
		return reviewers;
	}

	public Reviewer get(Integer reviewerId) {
		String url = "http://localhost:8080/api/reviewer/"+reviewerId;
		
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
		Reviewer reviewer = gson.fromJson( resp.body().toString() , Reviewer.class );
			
		return reviewer;
	}

	public void update(Integer reviewerId, Integer status) throws IOException {
		URL url = new URL( "http://localhost:8080/api/reviewer/" + reviewerId );
		
		JSONObject reviewerJson = new JSONObject();
		reviewerJson.put( "reviewer_status", status );
		
		String requestBody = reviewerJson.toString();
		
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

	public void delete(Integer reviewerId) throws IOException {
		
	}

}
