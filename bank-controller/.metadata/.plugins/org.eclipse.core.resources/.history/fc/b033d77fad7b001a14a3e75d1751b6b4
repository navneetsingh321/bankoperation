package com.springboot.platform.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.platform.dao.BankDAO;
import com.springboot.platform.error.BNKError;
import com.springboot.platform.error.BNKErrors.CODE;
import com.springboot.platform.error.BNKErrors.TYPE;
import com.springboot.platform.exception.InvalidInputException;
import com.springboot.platform.input.LoginInput;
import com.springboot.platform.model.Login;
import com.springboot.platform.persistence.Persistence;

public class BankDAOImpl implements BankDAO {
	
	@Autowired
	Persistence persistence ; 

	@Override
	public Login getLogin(LoginInput loginInput) throws InvalidInputException {
		Login login = persistence.findUserByName(loginInput.getUsername(),loginInput.getPassword());
		return login;
	}

}
