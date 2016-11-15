package com.hengtian.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hengtian.po.User;

public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 方法执行前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//拦截url进行身份确认的验证
		System.out.println("执行拦截器");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		if(u!=null){
			return true;
		}
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		return false;
	}

	/**
	 * 方法返回前拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 方法执行完成后拦截，记录日志异常处理等，放在第一个拦截器，preHandle需要返回true，放行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
