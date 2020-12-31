package com.reviewdekho.comment.dao;

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
import com.reviewdekho.comment.model.Comment;
import com.reviewdekho.report.model.Report;

public class CommentDao implements CommentDaoI {

	public int add(Comment comment) throws MalformedURLException, IOException {
		URL url = new URL( "http://localhost:8080/api/comment" );		
		
		JSONObject commentJson = new JSONObject( comment );
		
		String data = commentJson.toString();
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

	public List<Comment> get() {
		String url = "http://localhost:8080/api/comment";
		
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
		Type commentListType = new TypeToken< List< Comment > >() {}.getType();
		List<Comment> comments = gson.fromJson( resp.body().toString(), commentListType );
		System.out.println(comments.get(0).getComment_desc());
		
		return comments;
	}

	public Comment get(Integer commentId) {
		String url = "http://localhost:8080/api/report/"+commentId;
		
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
		Comment comment = gson.fromJson( resp.body().toString(), Comment.class );
		System.out.println(comment.getComment_desc());
		
		return comment;
	}

	public List<Comment> getCommentByReview(Integer reviewId) {
		String url = "http://localhost:8080/api/comment/review/"+reviewId;
		
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
		Type commentListType = new TypeToken< List< Comment > >() {}.getType();
		List<Comment> comments = gson.fromJson( resp.body().toString(), commentListType );
//		System.out.println(comments.get(0).getComment_desc());
		
		return comments;
	}

	public int update(Integer commentId, Comment comment) throws MalformedURLException, IOException {
		return 0;
	}

	public int delete(Integer commentId) throws MalformedURLException, IOException {
		return 0;
	}

}
