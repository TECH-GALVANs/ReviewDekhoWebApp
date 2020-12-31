package com.reviewdekho.product.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.product.model.Product;

public interface ProductDaoI {
	void addProduct( Product product ) throws MalformedURLException, IOException;
	List< Product > getProduct();
	Product getProduct( final Integer productId );
	void updateProduct( final Integer productId, Product product ) throws IOException;
	void deleteProduct( final Integer productId ) throws IOException;
}
