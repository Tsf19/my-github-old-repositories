package com.jsp.action;

public class TestBean {
	private String message = "No Message Specified";

	public String getMessage() {
		return message + "&..from .java";
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
