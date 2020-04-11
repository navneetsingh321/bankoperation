package com.springboot.platform.exception;

@SuppressWarnings("serial")
public class BaseException extends Exception {
	
	String message = null;
	Exception exception = null;
	String exceptionClass = null;
	
	public BaseException(Exception e) {
		this.exceptionClass = e.getClass().getName();
		this.message = e.getMessage();
		this.exception = e;
	}
	
	public BaseException(String message) {
		this.message = message;
	}

}

