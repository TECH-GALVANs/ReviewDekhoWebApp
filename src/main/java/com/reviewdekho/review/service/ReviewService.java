package com.reviewdekho.review.service;

import java.io.IOException;
import java.util.List;

import com.reviewdekho.review.dao.ReviewDao;
import com.reviewdekho.review.dao.ReviewDaoI;
import com.reviewdekho.review.model.Review;

public class ReviewService {
	private ReviewDao dao;
	
	public ReviewService() {
		dao = new ReviewDao();
	}
	
	public int add( Review review ) throws IOException {
		return dao.add(review);
	}
	
	public List< Review > get(){
		return dao.get();
	}
	
	public Review get( Integer review_id ) {
		return dao.get(review_id);
	}
	
	public int update( Integer review_id, Review review ) throws IOException {
		return dao.update(review_id, review);
	}
	
	public int delete( Integer review_id ) throws IOException {
		return dao.delete(review_id);
	}
}
