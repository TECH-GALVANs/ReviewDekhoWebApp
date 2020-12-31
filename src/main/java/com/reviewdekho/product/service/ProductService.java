package com.reviewdekho.product.service;

import java.io.IOException;
import java.util.List;

import com.reviewdekho.product.dao.ProductDao;
import com.reviewdekho.product.model.Product;
import com.reviewdekho.subcategory.model.SubCategory;

public class ProductService {
	private ProductDao dao;
	
	public ProductService() {
		dao = new ProductDao();
	}
	
	public void add( Product product ) throws IOException {
		dao.addProduct(product);
	}
	
	public List<Product> get(){
		return dao.getProduct();
	}
	
	public Product getById( Integer productId ) {
		return dao.getProduct(productId);
	}
	
	public void update( Integer productId, Product product ) throws IOException {
		dao.updateProduct(productId, product);
	}
	
	public void delete( Integer productId ) throws IOException {
		dao.deleteProduct(productId);
	}
}
