package com.springboot.platform.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.platform.controller.LoginController;
import com.springboot.platform.dao.BankDAO;
import com.springboot.platform.exception.InvalidInputException;
import com.springboot.platform.input.LoginInput;
import com.springboot.platform.input.SignupInput;
import com.springboot.platform.model.Login;
import com.springboot.platform.model.Signup;
import com.springboot.platform.persistence.Persistence;

public class BankDAOImpl implements BankDAO {
	
	@Autowired
	Persistence persistence ; 
	
	@Autowired
	LoginController manageLogin;

	@Override
	public void saveLogin(LoginInput loginInput) throws InvalidInputException {
		Login login = persistence.findUserByName(loginInput.getUsername(),loginInput.getPassword());
		persistence.saveObjectToDb(login);
	}

	@Override
	public void saveSignup(SignupInput signupInput){
		Signup signup = new Signup();
		signup.setId(signupInput.getId());
		signup.setFirstName(signupInput.getFirstName());
		signup.setLastName(signupInput.getLastName());
		signup.setEmailId(signupInput.getEmailId());
		signup.setUsername(signupInput.getUsername());
		signup.setPassword(signupInput.getPassword());
		signup.setConfirmPassword(signupInput.getConfirmPassword());
		persistence.saveObjectToDb(signup);
	}

	@Override
	public List<Signup> getSignupList() {
		return persistence.findListSignup();
	}

	@Override
	public Signup getSignupById(String id) {
		return persistence.findSignupById(id);
	}

	@Override
	public Signup updateSignup(SignupInput signupInput) {
		Signup signup = new Signup();
		signup.setId(signupInput.getId());
		signup.setFirstName(signupInput.getFirstName());
		signup.setLastName(signupInput.getLastName());
		signup.setEmailId(signupInput.getEmailId());
		signup.setUsername(signupInput.getUsername());
		signup.setPassword(signupInput.getPassword());
		signup.setConfirmPassword(signupInput.getConfirmPassword());
		persistence.mergeObjectToDb(signup);
		return signup;
	}

	@Override
	public Signup deleteSignup(String id) {
		return persistence.deleteObjectfromDB(id);
	}
}
