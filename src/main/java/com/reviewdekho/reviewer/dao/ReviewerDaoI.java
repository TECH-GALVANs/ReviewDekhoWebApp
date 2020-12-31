package com.reviewdekho.reviewer.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.product.model.Product;
import com.reviewdekho.reviewer.model.Reviewer;

public interface ReviewerDaoI {
	void add( Reviewer reviewer ) throws MalformedURLException, IOException;
	List< Reviewer > get();
	Reviewer get( final Integer reviewerId );
	void update( final Integer reviewerId, Integer status ) throws IOException;
	void delete( final Integer reviewerId ) throws IOException;
}
