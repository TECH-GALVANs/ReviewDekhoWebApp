package com.reviewdekho.subcategory.dao;

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
import com.reviewdekho.category.model.Category;
import com.reviewdekho.product.model.Product;
import com.reviewdekho.subcategory.model.SubCategory;

public class SubCategoryDao implements SubCategoryDaoI {

	public void addSubCategory(SubCategory subCategory) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		URL url = new URL( "http://localhost:8080/api/sub-category" );
		
		JSONObject categoryJson = new JSONObject();
		categoryJson.put( "category_id", subCategory.getCategory().getCategory_id() );
	
		JSONObject subCategoryJson = new JSONObject();
		subCategoryJson.put( "sub_category_name", subCategory.getSub_category_name() );
		subCategoryJson.put("category", categoryJson);
		
//		Gson gson = new Gson();
//		gson.toJson( subCategory );
//		
		String requestBody = subCategoryJson.toString();
		
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

	public List<SubCategory> getSubCategory() {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/api/sub-category";
		
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
		Type subCategoryListType = new TypeToken< List< SubCategory > >() {}.getType();
		List<SubCategory> subCategories = gson.fromJson( resp.body().toString(), subCategoryListType );
		return subCategories;
	}

	public SubCategory getSubCategory(Integer subCategoryId) {
		// TODO Auto-generated method stub
	String url = "http://localhost:8080/api/sub-category/" + subCategoryId;
		
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
		SubCategory subCategory = gson.fromJson( resp.body().toString(), SubCategory.class );
		return subCategory;
	}

	public void updateSubCategory(Integer SubCategoryId, SubCategory subCategory) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL( "http://localhost:8080/api/sub-category/" + SubCategoryId );
		
//		JSONObject categoryJson = new JSONObject();
//		categoryJson.put( "category_id", subCategory.getCategory().getCategory_id() );
//	
		JSONObject subCategoryJson = new JSONObject();
		subCategoryJson.put( "sub_category_name", subCategory.getSub_category_name() );
//		subCategoryJson.put("category", categoryJson);

//		Gson gson = new Gson();
//		gson.toJson( subCategory );
		
		String requestBody = subCategoryJson.toString();
		
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

	public void deleteSubCategory(Integer subCategoryId) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL( "http://localhost:8080/api/sub-category/"+subCategoryId );
		
		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "DELETE" );
		postReq.setRequestProperty( "Content-Type", "application/json" );

		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
	}

}
