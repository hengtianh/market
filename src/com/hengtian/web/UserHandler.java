package com.hengtian.web;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengtian.exceptions.UserException;
import com.hengtian.po.User;
import com.hengtian.service.UserService;
import com.hengtian.utils.MailUtil;

@Controller
@RequestMapping("/users")
public class UserHandler {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	MailUtil mailUtil;

	/**
	 * �û���¼����
	 * @param
	 * @return ��ҳ���߼���ͼ��
	 */
	@RequestMapping("/login")
	public String login(User u,Integer checkme,HttpSession session, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = null;
		try{
			user = uService.findUserToLogin(u,checkme);
			session.setAttribute("user", user);
			//request.getRequestDispatcher("index").forward(request, response);
		}catch(UserException ex){
			request.setAttribute("loginUser", u);
			throw ex;
		}catch(Exception e){
			String message = "�û������������";
//			response.setContentType("text/html;charset=utf-8");
//			response.setCharacterEncoding("utf-8");
//			response.getWriter().print(message);
			//request.setAttribute("errorUser", message);
			throw new UserException(message);
		}
		return "index";
	}
	
	
	/**
	 * ��֤Ҫ�����Ƿ����
	 * @param email ע������� 
	 * @param response ��Ӧ����
	 * @throws Exception 
	 */
	@RequestMapping("/exist")
	public void exist(String email, HttpServletResponse response) throws Exception {
		String result = uService.ifUserExist(email);
		if(result!=null){
			response.getWriter().write(result);
		}else{
			response.getWriter().write("");
		}
	}
	
	/**
	 * �û���¼����
	 * @param user
	 * @return ��ҳ���߼���ͼ��
	 */
	@RequestMapping("/regist")
	public String regist(User user, Model model) throws Exception {
		uService.insertUser(user);
		model.addAttribute("info", "ע��ɹ��������ʼ��ѷ��ͣ���ע����գ�");
		return "info";
	}
	
	/**
	 * �û��޸ĸ�����Ϣ����
	 * @param user �޸ĺ��ʵ����Ϣ
	 * @return ��ҳ���߼���ͼ��
	 */
	@RequestMapping("/modifySetting")
	public String modifySetting(User user,HttpSession session) throws Exception {
		//�����û���Ϣ
		uService.updateUser(user);
		//����֮ǰ��session����
		session.removeAttribute("user");
		//��������session
		session.setAttribute("user", user);
		return "index";
	}
	
	/**
	 * ����ע���˻�
	 * @param email ע���email��ַ
	 * @return true ����ɹ�
	 */
	@RequestMapping("/active")
	public void activeAccount(String email) throws Exception {
		uService.updateUserActived(email);
	}
	
	/**
	 * �˳���¼
	 * @param session�����
	 * @return void
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		if(session.getAttribute("user")!=null){
			session.removeAttribute("user");
		}
		return "index";
	}
	
	/**
	 * �����ʼ�����
	 * @param email ���͵�ַ
	 * @param realName �ռ�������
	 * @param model ҳ�洫������
	 * @return null
	 * @throws Exception ����ʧ��
	 */
	@RequestMapping("/sendMail")
	public String sendMail(String email, String realName, Model model) throws Exception {
		try{
			mailUtil.sendMail(email, realName);
		}catch(Exception ex){
			model.addAttribute("message", "�ʼ�����ʧ�ܣ�������");
			throw ex;
		}
		return null;
	}
	
	/**
	 * ת����ҳ
	 * @return
	 */
	@RequestMapping("/home")
	public String toHome() {
		return "index";
	}
	
	/**
	 * ת���������ҳ
	 * @return
	 */
	@RequestMapping("/setting")
	public String toSetting() {
		return "setting";
	}
}