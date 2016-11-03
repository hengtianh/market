package com.hengtian.dao;

import com.hengtian.po.User;

public interface UserDao {
	public User findUserToLogin(User user);
}
