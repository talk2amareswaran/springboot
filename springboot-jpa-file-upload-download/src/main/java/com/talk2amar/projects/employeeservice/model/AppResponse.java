package com.talk2amar.projects.employeeservice.model;

public class AppResponse {

	private String code;
	private String message;

	public AppResponse() {

	}

	public AppResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
