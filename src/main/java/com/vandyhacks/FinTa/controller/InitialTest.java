package com.vandyhacks.FinTa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialTest {

	@GetMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}
}
