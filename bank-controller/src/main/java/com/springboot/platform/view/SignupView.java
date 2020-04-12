package com.springboot.platform.view;

import com.springboot.platform.model.Signup;

public class SignupView {

	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String username;
	private String passowrd;
	private String confirmPassword;
	
/*	public SignupView(){}*/

	public SignupView(Signup signup) {
		this.id = signup.getId();
		this.firstName = signup.getFirstName();
		this.lastName = signup.getLastName();
		this.emailId = signup.getEmailId();
		this.username = signup.getUsername();
		this.passowrd = signup.getPassword();
		this.confirmPassword = signup.getConfirmPassword();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
