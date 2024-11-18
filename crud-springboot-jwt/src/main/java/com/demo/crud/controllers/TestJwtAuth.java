package com.demo.crud.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/jwt")
public class TestJwtAuth {

	@GetMapping("test")
	public Map<String, String> testEndpoint(@RequestAttribute("username") String username) {
		Map<String, String> response = new HashMap<>();
		response.put("message", "Request successful");
		response.put("username", username);
		return response;
	}
}
