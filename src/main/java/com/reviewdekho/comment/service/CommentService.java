package com.reviewdekho.comment.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.comment.dao.CommentDao;
import com.reviewdekho.comment.model.Comment;

public class CommentService {
	private CommentDao dao;
	
	public CommentService() {
		dao = new CommentDao();
	}
	
	public int add( Comment comment ) throws MalformedURLException, IOException {
		return dao.add(comment);
	}
	
	public List< Comment > get(){
		return dao.get();
	}
	
	public Comment get( Integer commentId) {
		return dao.get(commentId);
	}
	
	public int update( Integer commentId, Comment comment ) throws MalformedURLException, IOException {
		return dao.update(commentId, comment);
	}
	
	public int delete( Integer commentId, Comment comment ) throws MalformedURLException, IOException {
		return dao.delete(commentId);
	}
	
	public List<Comment> getCommentByReview( Integer reviewId ){
		return dao.getCommentByReview(reviewId);
	}
}
