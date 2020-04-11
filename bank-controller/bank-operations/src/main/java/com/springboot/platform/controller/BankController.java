package com.springboot.platform.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banks")
public class BankController {
	@RequestMapping("")
	public String hello() {
		return "Hello Bankers";
	}
}
