package com.demo.webservice.demowebservice;

public class hellobean {
	private String message="";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public hellobean(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "hellobean [message=" + message + "]";
	}
	

}
