package com.hengtian.service;

import com.hengtian.po.User;

public interface UserService {
	public User findUserToLogin(User user,Integer checkme) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public boolean updateUserActived(String email) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public String ifUserExist(String email) throws Exception;
	
	public boolean adminLogin(String username, String password) throws Exception;
}
