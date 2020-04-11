package com.springboot.platform.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.platform.dao.BankDAO;
import com.springboot.platform.daoimpl.BankDAOImpl;
import com.springboot.platform.exception.InvalidInputException;
import com.springboot.platform.input.LoginInput;
import com.springboot.platform.model.Login;
import com.springboot.platform.service.BankService;

public class BankServiceImpl implements BankService {

	@Autowired
	BankDAOImpl bankDao;

	@Override
	public Login getLogin(LoginInput loginInput) throws InvalidInputException {
		return bankDao.getLogin(loginInput);
	}

}
