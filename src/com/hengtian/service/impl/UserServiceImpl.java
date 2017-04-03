package com.hengtian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hengtian.exceptions.UserException;
import com.hengtian.mapper.UserMapper;
import com.hengtian.po.Admin;
import com.hengtian.po.User;
import com.hengtian.service.UserService;
import com.hengtian.utils.MailUtil;

public class UserServiceImpl implements UserService {
	
	private MailUtil mailUtil;
	
	public void setMailUtil(MailUtil mailUtil) {
		this.mailUtil = mailUtil;
	}

	@Autowired
	private UserMapper userMapper;

	/**
	 * 登录时查找用户是否存在,是否激活
	 * @param 封装有用户名和密码的User对象
	 * @return 查找到的登录用户对象，封装完整信息
	 * @throws Exception 
	 */
	@Override
	public User findUserToLogin(User user,Integer checkme) throws Exception {
		User u = userMapper.findUserToLogin(user);
		if(u==null) {
			//用户名或密码错误
			throw new Exception("用户名或密码错误");
		}
		if(u!=null && u.getActived()==0) {
			throw(new UserException("该用户还未激活"));
		}
		return u;
	}

	/**
	 * 注册用户插入注册对象,发送激活邮件
	 * @param 注册的对象
	 * @return void
	 * @throws Exception 
	 */
	@Override
	public void insertUser(User user) throws Exception {
		//插入注册的用户
		userMapper.insertUser(user);
		try{
			//发送激活邮件
			mailUtil.sendMail(user.getEmail(),user.getRealName());
			//System.out.println("邮件发送成功");
		}catch(Exception ex){
			throw(new Exception("服务器网络故障，邮件未正常发送"));
		}
	}

	/**
	 * 激活用户邮箱
	 * @param 要激活的邮箱
	 * @return true 激活成功
	 */
	@Override
	public boolean updateUserActived(String email) throws Exception {
		userMapper.updateUserActived(email);
		return true;
	}

	/**
	 * @param user更新的对象
	 * @return void
	 */
	@Override
	public void updateUser(User user) throws Exception {
		userMapper.updateUser(user);
	}

	/**
	 * 查找email是否存在
	 * @param email地址
	 * @return 找到的email
	 */
	@Override
	public String ifUserExist(String email) throws Exception {
		return userMapper.findUserByEmail(email);
	}


	@Override
	public boolean adminLogin(String username, String password) throws Exception {
		/**
		 * 管理員登錄
		 */		
		Admin admin = new Admin(username, password);
		Admin a = userMapper.findAdmin(admin);
		boolean r = false;
		if (a != null){
			r = true;
		}
		return r;
	}

}
