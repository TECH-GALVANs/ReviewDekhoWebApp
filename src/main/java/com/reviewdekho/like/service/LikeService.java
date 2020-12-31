package com.reviewdekho.like.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.like.dao.LikeDao;
import com.reviewdekho.like.model.Like;

public class LikeService {
	private LikeDao dao;
	
	public LikeService() {
		dao = new LikeDao();
	}
	
	public int add( Like like ) throws MalformedURLException, IOException {
		return dao.add(like);
	}
	
	public List< Like > get(){
		return dao.get();
	}
	
	public List< Like > getByReviewId( Integer reviewId ){
		return dao.getByReviewId(reviewId);
	}
	
	public Like get( Integer like_id ) {
		return dao.get(like_id);
	}
	
	public int update( Integer like_id, Like like ) throws MalformedURLException, IOException {
		return dao.update(like_id, like);
	}
	
	public int delete( Integer like_id ) throws MalformedURLException, IOException {
		return dao.delete(like_id);
	}
}
