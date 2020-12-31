package com.reviewdekho.reviewer.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.reviewer.dao.ReviewerDao;
import com.reviewdekho.reviewer.model.Reviewer;

public class ReviewerService {
	private ReviewerDao dao;
	
	public ReviewerService() {
		dao = new ReviewerDao();
	}
	
	public void add( Reviewer reviewer ) throws MalformedURLException, IOException {
		dao.add(reviewer);
	}
	
	public List<Reviewer> get(){
		return dao.get();
	}
	
	public Reviewer get( Integer reviewerId ) {
		return dao.get(reviewerId);
	}
	
	public void update ( Integer reviewerId, Integer status ) throws IOException {
		dao.update(reviewerId, status );
	}
}
