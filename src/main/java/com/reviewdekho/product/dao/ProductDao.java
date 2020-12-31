package com.reviewdekho.product.dao;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.lang.runtime.ObjectMethods;
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
import com.reviewdekho.product.model.Product;
import com.reviewdekho.subcategory.model.SubCategory;
import com.google.gson.reflect.TypeToken;

public class ProductDao implements ProductDaoI {

	public void addProduct(Product product) throws MalformedURLException, IOException {
		URL url = new URL( "http://localhost:8080/api/product" );
		
		JSONObject productJson = new JSONObject();
		System.out.println(product.getImage());
		System.out.println(product.getImageType());
		productJson.put( "product_name", product.getProduct_name() );
		productJson.put( "product_desc", product.getProduct_desc() );
		productJson.put( "image", product.getImage() );
		productJson.put( "imageType", product.getImageType());
		productJson.put( "product_price", product.getProduct_price() );
		
		JSONObject subCategoryJson = new JSONObject();
		subCategoryJson.put( "sub_category_id", product.getSubCategory().getSub_category_id() );
		
		productJson.put( "subCategory", subCategoryJson );
		
		String requestBody = productJson.toString();
		
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

	public List<Product> getProduct() {
		String url = "http://localhost:8080/api/product";
		
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
		
//		System.out.println(resp.statusCode());
//		System.out.println(resp.body());
//		
		Gson gson = new Gson();
		Type productListType = new TypeToken< List< Product > >() {}.getType();
		List<Product> products = gson.fromJson( resp.body().toString(), productListType );
		System.out.println(products.get(0).getProduct_name());
		
		return products;
	}

	public Product getProduct(Integer productId) {
		String url = "http://localhost:8080/api/product/"+productId;
		
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
		Product product = gson.fromJson( resp.body().toString() , Product.class );
			
		return product;
	}

	public void updateProduct(Integer productId, Product product) throws IOException {
		URL url = new URL( "http://localhost:8080/api/product/" + productId );
		
//		Gson gson = new Gson();
//		gson.toJson( product );
		
		JSONObject productJson = new JSONObject();
		System.out.println(product.getProduct_name());
		productJson.put( "product_name", product.getProduct_name() );
		productJson.put( "product_desc", product.getProduct_desc() );
		productJson.put( "product_price", product.getProduct_price() );
		
		String requestBody = productJson.toString();
		
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

	public void deleteProduct(Integer productId) throws IOException {
		URL url = new URL( "http://localhost:8080/api/product/"+productId );
		
		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "DELETE" );
		postReq.setRequestProperty( "Content-Type", "application/json" );

		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
	}

}
