package com.springboot.platform.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.platform.daoimpl.BankDAOImpl;
import com.springboot.platform.exception.InvalidInputException;
import com.springboot.platform.input.LoginInput;
import com.springboot.platform.input.SignupInput;
import com.springboot.platform.model.Signup;
import com.springboot.platform.service.BankService;

public class BankServiceImpl implements BankService {

	@Autowired
	BankDAOImpl bankDao;

	@Override
	public void saveLogin(LoginInput loginInput) throws InvalidInputException {
		 bankDao.saveLogin(loginInput);
	}

	@Override
	public void saveSignup(SignupInput signupInput) {
		bankDao.saveSignup(signupInput);
	}

	@Override
	public List<Signup> getSignupList() {
		return bankDao.getSignupList();
	}

	@Override
	public Signup getSignupById(String id) {
		return bankDao.getSignupById(id);
	}

	@Override
	public Signup updateSignup(SignupInput signupInput) {
		return bankDao.updateSignup(signupInput);
		
	}

	@Override
	public Signup deleteSignup(String id) {
		return bankDao.deleteSignup(id);
	}
}
