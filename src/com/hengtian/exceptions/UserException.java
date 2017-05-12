package com.hengtian.exceptions;

/**
 * 自定义的User异常类
 * @author tian heng
 *
 */
@SuppressWarnings("serial")
public class UserException extends Exception {
	
	private String message;
	
	public UserException(String message) {
		super(message);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
