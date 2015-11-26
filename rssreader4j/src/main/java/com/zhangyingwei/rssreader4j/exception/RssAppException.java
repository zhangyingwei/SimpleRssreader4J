package com.zhangyingwei.rssreader4j.exception;


public class RssAppException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public RssAppException(String message){
		super(message);
	}
	
	public RssAppException(){
		super();
	}
	
	public RssAppException(Throwable thro){
		super(thro);
	}
	
	public RssAppException(String message,Throwable thro){
		super(message, thro);
	}
}
