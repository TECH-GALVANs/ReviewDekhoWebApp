package com.reviewdekho.review.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.review.model.Review;

public interface ReviewDaoI {
	public int add( Review review ) throws MalformedURLException, IOException;
	public List< Review > get();
	public Review get( Integer review_id );
	public int update( Integer review_id, Review review ) throws MalformedURLException, IOException;
	public int delete( Integer review_id ) throws MalformedURLException, IOException;
}
