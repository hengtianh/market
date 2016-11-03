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
		//打印异常信息
		ex.printStackTrace();
		
		UserException exception = null;
		String message = null;
		//对自定义异常处理
		if(ex instanceof UserException){
			exception = (UserException) ex;
			message = exception.getMessage();
		}else{
			//对非自定义异常，构造成未知异常处理
			//exception = new UserException("未知错误");
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
