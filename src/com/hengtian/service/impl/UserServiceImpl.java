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
	 * ��¼ʱ�����û��Ƿ����,�Ƿ񼤻�
	 * @param ��װ���û����������User����
	 * @return ���ҵ��ĵ�¼�û����󣬷�װ������Ϣ
	 * @throws Exception 
	 */
	@Override
	public User findUserToLogin(User user,Integer checkme) throws Exception {
		User u = userMapper.findUserToLogin(user);
		if(u==null) {
			//�û������������
			throw new Exception("�û������������");
		}
		if(u!=null && u.getActived()==0) {
			throw(new UserException("���û���δ����"));
		}
		return u;
	}

	/**
	 * ע���û�����ע�����,���ͼ����ʼ�
	 * @param ע��Ķ���
	 * @return void
	 * @throws Exception 
	 */
	@Override
	public void insertUser(User user) throws Exception {
		//����ע����û�
		userMapper.insertUser(user);
		try{
			//���ͼ����ʼ�
			mailUtil.sendMail(user.getEmail(),user.getRealName());
			//System.out.println("�ʼ����ͳɹ�");
		}catch(Exception ex){
			throw(new Exception("������������ϣ��ʼ�δ��������"));
		}
	}

	/**
	 * �����û�����
	 * @param Ҫ���������
	 * @return true ����ɹ�
	 */
	@Override
	public boolean updateUserActived(String email) throws Exception {
		userMapper.updateUserActived(email);
		return true;
	}

	/**
	 * @param user���µĶ���
	 * @return void
	 */
	@Override
	public void updateUser(User user) throws Exception {
		userMapper.updateUser(user);
	}

	/**
	 * ����email�Ƿ����
	 * @param email��ַ
	 * @return �ҵ���email
	 */
	@Override
	public String ifUserExist(String email) throws Exception {
		return userMapper.findUserByEmail(email);
	}


	@Override
	public boolean adminLogin(String username, String password) throws Exception {
		/**
		 * ����T���
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
