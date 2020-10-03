package com.vandyhacks.FinTa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class InitialTest {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}
}
