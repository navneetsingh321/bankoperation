package com.springboot.platform.service;

import com.springboot.platform.exception.InvalidInputException;
import com.springboot.platform.input.LoginInput;
import com.springboot.platform.model.Login;

public interface BankService {
	
	public Login getLogin(LoginInput loginInput) throws InvalidInputException;

}
