package com.align.test.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class Monitor {
	
	@Autowired
	private Environment environment;
	
	public static long appStartTime=System.currentTimeMillis();;
	
	
	
	@GetMapping("status")
	public ResponseEntity<String> getStatus() {
		String port = environment.getProperty("local.server.port");
		String env = environment.getProperty("env");
		
		return new ResponseEntity<>("environment: "+env +" port: "+ port +" StartUptime: "+ appStartTime, HttpStatus.OK);
	}

}
