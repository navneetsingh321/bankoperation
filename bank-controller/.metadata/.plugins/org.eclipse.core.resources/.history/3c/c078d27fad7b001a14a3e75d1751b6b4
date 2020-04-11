package com.springboot.platform.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.springboot.platform.error.BNKError;



@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputException extends BaseException{

	List<BNKError> errors = null;
	
	public InvalidInputException(Exception e) {
		super(e);
	}
	
	public InvalidInputException(List<BNKError> errors) {
		super("Invalid Input");
		this.errors = errors;
	}
	
	public InvalidInputException(BNKError error) {
		super("Invalid Input");
		this.errors = new ArrayList<BNKError>();
		this.errors.add(error);
	}

	public List<BNKError> getErrors() {
		return errors;
	}

}
