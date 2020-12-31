package com.reviewdekho.image.dao;

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
import com.reviewdekho.image.model.ProductImage;

public class ProductImageDao implements ImageDaoI {

	public int add(ProductImage image) throws IOException {
		URL url = new URL( "http://localhost:8080/api/image" );		
		
		JSONObject imageJson = new JSONObject( image );
		
		String data = imageJson.toString();
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

	public List<ProductImage> get() {
		String url = "http://localhost:8080/api/image";
		
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
		Type imageListType = new TypeToken< List< ProductImage > >() {}.getType();
		List<ProductImage> images = gson.fromJson( resp.body().toString(), imageListType );
		System.out.println(images.get(0).getImage_id());
		
		return images;
	}

	public ProductImage get(Integer imageId) {
		String url = "http://localhost:8080/api/image/"+imageId;
		
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
		ProductImage image = gson.fromJson( resp.body().toString(), ProductImage.class );
		System.out.println(image.getImage_id());
		
		return image;
	}

	public int update(Integer imageId, ProductImage image) throws MalformedURLException, IOException {
		return 0;
	}

	public int delete(Integer ImageId) throws MalformedURLException, IOException {
		return 0;
	}
	
}
