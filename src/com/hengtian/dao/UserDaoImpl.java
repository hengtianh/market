package com.hengtian.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hengtian.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findUserToLogin(User user) {
		User u = this.getSqlSession().selectOne("user.findUserToLogin", user);
		return u;
	}

}
