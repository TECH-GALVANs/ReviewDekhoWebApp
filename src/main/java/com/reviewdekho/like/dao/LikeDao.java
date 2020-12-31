package com.reviewdekho.like.dao;

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
import com.reviewdekho.like.model.Like;
import com.reviewdekho.review.model.Review;

public class LikeDao implements LikeDaoI {

	public int add(Like like) throws MalformedURLException, IOException {
		URL url = new URL( "http://localhost:8080/api/like" );		
		
		JSONObject likeJson = new JSONObject( like );
		
		String data = likeJson.toString();
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

	public List<Like> get() {
		String url = "http://localhost:8080/api/like";
		
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
		Type likeListType = new TypeToken< List< Like > >() {}.getType();
		List<Like> likes = gson.fromJson( resp.body().toString(), likeListType );
		System.out.println(likes.get(0).getLike_id());
		
		return likes;
	}

	public Like get(Integer like_id) {
		String url = "http://localhost:8080/api/like/"+like_id;
		
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
		Like like = gson.fromJson( resp.body().toString(), Like.class );
		System.out.println( like.getLike_id() );
		
		return like;
	}

	public int update(Integer like_id, Like like) throws MalformedURLException, IOException {
		URL url = new URL( "http://localhost:8080/api/like/"+like_id );		
		
		JSONObject reviewJson = new JSONObject( like );
		
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

	public int delete(Integer like_id) throws MalformedURLException, IOException {
		URL url = new URL( "http://localhost:8080/api/like/"+like_id );
		
		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "DELETE" );
		postReq.setRequestProperty( "Content-Type", "application/json" );

		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
		return responseCode;
	}

	public List<Like> getByReviewId( Integer reviewId ) {
		String url = "http://localhost:8080/api/like/review/"+reviewId;
		
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
		Type likeListType = new TypeToken< List< Like > >() {}.getType();
		List<Like> likes = gson.fromJson( resp.body().toString(), likeListType );
//		System.out.println(likes.get(0).getLike_id());
		
		return likes;
	}

}
