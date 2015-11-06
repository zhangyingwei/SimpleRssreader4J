package com.zhangyingwei.exception;


public class AppException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AppException(String message){
		super(message);
	}
	
	public AppException(){
		super();
	}
	
	public AppException(Throwable thro){
		super(thro);
	}
	
	public AppException(String message,Throwable thro){
		super(message, thro);
	}
}
