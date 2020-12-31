package com.reviewdekho.image.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

import com.reviewdekho.image.dao.ProductImageDao;
import com.reviewdekho.image.model.ProductImage;

public class ImageService {
	private ProductImageDao dao;
	
	public ImageService() {
		dao = new ProductImageDao();
	}
	
	public int add( ProductImage image ) throws IOException, SQLException {
		return dao.add(image);
	}
	
	public List< ProductImage > get(){
		return dao.get();
	}
	
	public ProductImage get( Integer imageId ) throws SQLException {
		return dao.get(imageId);
	}
	
	public int update( Integer imageId, ProductImage image ) throws MalformedURLException, IOException {
		return dao.update(imageId, image);
	}
	
	public int delete( Integer imageId ) throws MalformedURLException, IOException {
		return dao.delete(imageId);
	}
}
