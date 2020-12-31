package com.reviewdekho.user.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.user.model.User;

public interface UserDaoI {
	public void add( User user ) throws MalformedURLException, IOException;
	public List< User > get();
	public User get( Integer userId );
	public void update( Integer userId, User user ) throws MalformedURLException, IOException;
	public void delete( Integer userId ) throws IOException;
}
