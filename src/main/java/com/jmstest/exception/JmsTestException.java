package com.jmstest.exception;

public class JmsTestException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String errorMess;
	
	public JmsTestException(String errorMess){
		super(errorMess);
		this.errorMess=errorMess;
	}
	
	public String getError(){
		return this.errorMess;
	}
}
