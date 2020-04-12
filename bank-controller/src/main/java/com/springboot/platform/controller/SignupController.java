package com.springboot.platform.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.platform.exception.InvalidInputException;
import com.springboot.platform.input.SignupInput;
import com.springboot.platform.model.Signup;
import com.springboot.platform.response.ListResponseObject;
import com.springboot.platform.response.SingleResponseObject;
import com.springboot.platform.serviceimpl.BankServiceImpl;
import com.springboot.platform.utils.Utils;
import com.springboot.platform.view.SignupView;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/banks")
public class SignupController {
	
	@Autowired
	BankServiceImpl bankService;
	
	@Transactional
	@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SingleResponseObject<String>> createSignup(@Valid @RequestBody SignupInput signupInput) throws InvalidInputException {
		signupInput.setId(Utils.generateUniqueId());
		bankService.saveSignup(signupInput);
		SingleResponseObject<String> resp = new SingleResponseObject<String>(signupInput.getId());
		return new ResponseEntity<SingleResponseObject<String>>(resp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ListResponseObject<List<SignupView>>> getSignups() {
		List<Signup> signups = bankService.getSignupList();
		List<SignupView> signupViews = new  ArrayList<SignupView>();
		for(Signup signup : signups){
			signupViews.add(new SignupView(signup));
		}
		ListResponseObject<List<SignupView>> resp = new ListResponseObject<List<SignupView>>(signupViews);
		return new ResponseEntity<ListResponseObject<List<SignupView>>>(resp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/signup/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SingleResponseObject<SignupView>> getSignupById(@NotNull @PathVariable(name = "id") String id) {
		Signup signup = bankService.getSignupById(id);
		SingleResponseObject<SignupView> respObj = new SingleResponseObject<SignupView>(new SignupView(signup));
		return new ResponseEntity<SingleResponseObject<SignupView>>(respObj, HttpStatus.OK);

	}
	
	@Transactional
	@RequestMapping(value = "/signup/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SingleResponseObject<String>> updateSignup(@Valid @RequestBody SignupInput signupInput) throws InvalidInputException {
		Signup signup = bankService.updateSignup(signupInput);
		SingleResponseObject<String> respObj = new SingleResponseObject<String>(signup.getId());
		return new ResponseEntity<SingleResponseObject<String>>(respObj, HttpStatus.OK);
	}
	
	@Transactional
	@RequestMapping(value = "/signup/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SingleResponseObject<String>> deleteSignup(@PathVariable(name = "id") String id) {
		Signup signup = bankService.deleteSignup(id);
		SingleResponseObject<String> respObj = new SingleResponseObject<String>(signup.getId());
		return new ResponseEntity<SingleResponseObject<String>>(respObj, HttpStatus.OK);

	}

}
