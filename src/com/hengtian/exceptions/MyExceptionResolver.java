package com.hengtian.exceptions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//��ӡ�쳣��Ϣ
		ex.printStackTrace();
		
		UserException exception = null;
		String message = null;
		//���Զ����쳣����
		if(ex instanceof UserException){
			exception = (UserException) ex;
			message = exception.getMessage();
		}else{
			//�Է��Զ����쳣�������δ֪�쳣����
			//exception = new UserException("δ֪����");
			message = ex.getMessage();
		}
		
		request.setAttribute("message", message);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
