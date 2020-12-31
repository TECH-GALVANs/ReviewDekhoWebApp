package com.reviewdekho.review.dao;

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
import com.reviewdekho.review.model.Review;

public class ReviewDao implements ReviewDaoI {

	public int add(Review review) throws IOException {
		URL url = new URL( "http://localhost:8080/api/review" );		
		
		JSONObject reviewJson = new JSONObject( review );
		
		String data = reviewJson.toString();
		System.out.println(data);

		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "POST" );
		postReq.setRequestProperty( "Content-Type", "application/json" );
		
		postReq.setDoOutput( true );
		OutputStream os = postReq.getOutputStream();
		os.write( data.getBytes() );
		os.flush();
		os.close();
		
		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
		
		if( responseCode == 200 )
			return 1;
		else
			return 0;
	}

	public List<Review> get() {
		String url = "http://localhost:8080/api/review";
		
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
		Type reviewListType = new TypeToken< List< Review > >() {}.getType();
		List<Review> reviews = gson.fromJson( resp.body().toString(), reviewListType );
		System.out.println(reviews.get(0).getReview_desc());
		
		return reviews;
	}

	public Review get(Integer review_id) {
		String url = "http://localhost:8080/api/review/"+review_id;
		
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
		Review review = gson.fromJson( resp.body().toString(), Review.class );
		System.out.println(review.getReview_desc());
		
		return review;
	}

	public int update(Integer review_id, Review review) throws IOException {
		URL url = new URL( "http://localhost:8080/api/review/"+review_id );		
		
		JSONObject reviewJson = new JSONObject( review );
		
		String data = reviewJson.toString();
		System.out.println(data);

		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "PUT" );
		postReq.setRequestProperty( "Content-Type", "application/json" );
		
		postReq.setDoOutput( true );
		OutputStream os = postReq.getOutputStream();
		os.write( data.getBytes() );
		os.flush();
		os.close();
		
		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
		
		if( responseCode == 200 )
			return 1;
		else
			return 0;
	}

	public int delete(Integer review_id) throws IOException {
		URL url = new URL( "http://localhost:8080/api/review/"+review_id );
		
		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "DELETE" );
		postReq.setRequestProperty( "Content-Type", "application/json" );

		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
		return responseCode;
	}

}
