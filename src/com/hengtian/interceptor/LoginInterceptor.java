package com.hengtian.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hengtian.po.User;

public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * ����ִ��ǰ����
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//����url�������ȷ�ϵ���֤
		System.out.println("ִ��������");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		if(u!=null){
			return true;
		}
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		return false;
	}

	/**
	 * ��������ǰ����
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * ����ִ����ɺ����أ���¼��־�쳣����ȣ����ڵ�һ����������preHandle��Ҫ����true������
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
