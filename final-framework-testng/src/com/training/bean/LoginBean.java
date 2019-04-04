package com.training.bean;

public class LoginBean {
	private String userName;
	private String password;
	String name,email,subject,message;

	public LoginBean() {
	}
/*
	public LoginBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + "]";
	}
*/
	public LoginBean(String name, String email, String sub, String mes) {
		super();
		this.name = name;
		this.email = email;
		this.subject= sub;
		this.message=mes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return email;
	}

	public void setMessage(String mes) {
		this.message = mes;
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String sub) {
		this.subject= sub;
	}


	@Override
	public String toString() {
		return "LoginBean [name=" + name + ", email=" + email + ",subject="+subject+",message="+message+"]";
	}
}
