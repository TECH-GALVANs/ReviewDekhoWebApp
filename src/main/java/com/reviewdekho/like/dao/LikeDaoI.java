package com.reviewdekho.like.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.like.model.Like;

public interface LikeDaoI {
	public int add( Like like ) throws MalformedURLException, IOException;
	public List< Like > get();
	public List< Like > getByReviewId( Integer reviewId );
	public Like get( Integer like_id );
	public int update( Integer like_id, Like like ) throws MalformedURLException, IOException;
	public int delete( Integer like_id ) throws MalformedURLException, IOException; 
}
