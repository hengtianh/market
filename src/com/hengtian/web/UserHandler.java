package com.hengtian.web;

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
	 * 用户登录方法
	 * @param
	 * @return 主页的逻辑视图名
	 */
	@RequestMapping("/login")
	public String login(User u,Integer checkme,HttpSession session, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = null;
		try{
			user = uService.findUserToLogin(u,checkme);
			session.setAttribute("user", user);
		}catch(UserException ex){
			request.setAttribute("loginUser", u);
			throw ex;
		}catch(Exception e){
			String message = "用户名或密码错误";
			throw new UserException(message);
		}
		return "redirect:/category/toIndex.action";
	}
	
	
	/**
	 * 验证要邮箱是否存在
	 * @param email 注册的邮箱 
	 * @param response 响应对象
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
	 * 用户登录方法
	 * @param user
	 * @return 主页的逻辑视图名
	 */
	@RequestMapping("/regist")
	public String regist(User user, Model model) throws Exception {
		uService.insertUser(user);
		model.addAttribute("info", "注册成功！激活邮件已发送，请注意查收！");
		return "jsp/info";
	}
	
	/**
	 * 用户修改个人信息方法
	 * @param user 修改后的实体信息
	 * @return 主页的逻辑视图名
	 */
	@RequestMapping("/modifySetting")
	public String modifySetting(User user,HttpSession session) throws Exception {
		//更新用户信息
		uService.updateUser(user);
		//设置之前的session过期
		session.removeAttribute("user");
		//重新设置session
		session.setAttribute("user", user);
		return "redirect:category/toIndex.action";
	}
	
	/**
	 * 激活注册账户
	 * @param email 注册的email地址
	 * @return true 激活成功
	 */
	@RequestMapping("/active")
	public String activeAccount(String email) throws Exception {
		uService.updateUserActived(email);
		return "jsp/index";
	}
	
	/**
	 * 退出登录
	 * @param session域对象
	 * @return void
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		if(session.getAttribute("user")!=null){
			session.removeAttribute("user");
		}
		return "redirect:/category/toIndex.action";
	}
	
	/**
	 * 发送邮件方法
	 * @param email 发送地址
	 * @param realName 收件人姓名
	 * @param model 页面传递数据
	 * @return null
	 * @throws Exception 发送失败
	 */
	@RequestMapping("/sendMail")
	public String sendMail(String email, String realName, Model model) throws Exception {
		try{
			mailUtil.sendMail(email, realName);
		}catch(Exception ex){
			model.addAttribute("message", "邮件发送失败，请重试");
			throw ex;
		}
		return "redirect:category/toIndex.action";
	}
	
	/**
	 * 转向主页
	 * @return
	 */
	@RequestMapping("/home")
	public String toHome() {
		return "redirect:category/toIndex.action";
	}
	
	/**
	 * 转向个人设置页
	 * @return
	 */
	@RequestMapping("/setting")
	public String toSetting() {
		return "jsp/sel/setting";
	}
}
