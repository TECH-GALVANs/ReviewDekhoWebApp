package com.reviewdekho.comment.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.comment.model.Comment;

public interface CommentDaoI {
	public int add( Comment comment ) throws MalformedURLException, IOException;
	public List< Comment > get();
	public Comment get( Integer commentId );
	public int update( Integer commentId, Comment comment ) throws MalformedURLException, IOException;
	public int delete( Integer commentId ) throws MalformedURLException, IOException;

}
