package com.springboot.platform.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.platform.exception.InvalidInputException;
import com.springboot.platform.input.LoginInput;
import com.springboot.platform.response.SingleResponseObject;
import com.springboot.platform.serviceimpl.BankServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/banks")
public class LoginController {
	
	
	@Autowired
	BankServiceImpl bankService;

	@Transactional
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SingleResponseObject<String>> login(@Valid @RequestBody LoginInput loginInput) throws InvalidInputException {
		bankService.saveLogin(loginInput);
		/*if ("".equals(loginInput.getUsername())) {
			throw new InvalidInputException(new BNKError(TYPE.VALIDATION_ERROR, CODE.INPUT_MISSING, null, "Missing input field: "));
		}
		if(login == null){
			throw new InvalidInputException(new BNKError(TYPE.VALIDATION_ERROR, CODE.AUTHORISATION_FAILED, null, "Invalid credentials"));
		}*/
		SingleResponseObject<String> resp = new SingleResponseObject<String>(loginInput.getId());
		return new ResponseEntity<SingleResponseObject<String>>(resp, HttpStatus.OK);
	}
}
