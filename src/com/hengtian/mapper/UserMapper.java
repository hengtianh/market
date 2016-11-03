package com.hengtian.mapper;

import com.hengtian.po.User;

public interface UserMapper {
	public User findUserToLogin(User user) throws Exception;
	public String findUserByEmail(String email) throws Exception;
	public void insertUser(User user) throws Exception;
	public void updateUserActived(String email) throws Exception;
	public void updateUser(User user) throws Exception;
}
