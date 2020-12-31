package com.reviewdekho.user.service;

import java.io.IOException;
import java.util.List;

import com.reviewdekho.user.dao.UserDao;
import com.reviewdekho.user.model.User;

public class UserService {
	private UserDao dao;
	
	public UserService() {
		dao = new UserDao();
	}
	
	public void add( User user ) throws IOException {
		dao.add(user);
	}
	
	public List< User > get(){
		return dao.get();
	}
	
	public User get( Integer userId ) {
		return dao.get(userId);
	}
	
	public void update ( Integer userId, User user ) throws IOException {
		dao.update(userId, user);
	}
	
	public void delete( Integer userId ) throws IOException {
		dao.delete(userId);
	}
	
	public User signUp( User user ) throws IOException {
		return dao.signUp(user);
	}
	
}
