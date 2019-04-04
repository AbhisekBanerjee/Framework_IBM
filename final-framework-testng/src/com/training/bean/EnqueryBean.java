package com.training.bean;

public class EnqueryBean {
	private String name,email,subject,message;
	
	public EnqueryBean() {
	}

	public EnqueryBean(String name, String email, String sub, String mes) {
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
		return "EnqueryBean [name=" + name + ", email=" + email + ",subject="+subject+",message="+message+"]";
	}

}
