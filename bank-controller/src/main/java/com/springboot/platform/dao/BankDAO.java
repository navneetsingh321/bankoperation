package com.springboot.platform.dao;

import java.util.List;

import com.springboot.platform.exception.InvalidInputException;
import com.springboot.platform.input.LoginInput;
import com.springboot.platform.input.SignupInput;
import com.springboot.platform.model.Signup;

public interface BankDAO {

	public void saveLogin(LoginInput loginInput) throws InvalidInputException;
	
	public void saveSignup(SignupInput signupInput);
	
	public List<Signup> getSignupList();
	
	public Signup getSignupById(String id);
	
	public Signup updateSignup(SignupInput signupInput);
	
	public Signup deleteSignup(String id);

}
