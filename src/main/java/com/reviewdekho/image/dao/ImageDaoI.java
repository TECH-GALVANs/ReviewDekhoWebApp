package com.reviewdekho.image.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.image.model.ProductImage;

public interface ImageDaoI {
	public int add( ProductImage image ) throws MalformedURLException, IOException;
	public List< ProductImage > get();
	public ProductImage get( Integer imageId );
	public int update( Integer imageId, ProductImage image ) throws MalformedURLException, IOException;
	public int delete( Integer ImageId ) throws MalformedURLException, IOException;

}
