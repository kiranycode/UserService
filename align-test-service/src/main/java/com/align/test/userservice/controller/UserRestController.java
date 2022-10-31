package com.align.test.userservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.align.test.userservice.request.UserRequest;
import com.align.test.userservice.response.UserResponse;
import com.align.test.userservice.service.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserRestController {

	@Autowired
	UserService userService;
	


	@PostMapping("createUser")
	public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {
		UserResponse userResponse = userService.addUser(userRequest);
		return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
	}
	
	// User shall be deleted or updated by using any of username or email or uuid

	@PutMapping("update/id/{userId}")
	public ResponseEntity<UserResponse> updateUserByUUID(@RequestBody UserRequest userRequest,
			@PathVariable(name = "userId") UUID userId) {
		UserResponse userResponse = userService.updateUserByUUID(userRequest, userId);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}
	
	@PutMapping("update/userName/{userName}")
	public ResponseEntity<UserResponse> updateUserByUserName(@RequestBody UserRequest userRequest,
			@PathVariable(name = "userName") String userName) {
		UserResponse userResponse = userService.updateUserByUserName(userRequest, userName);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}
	
	@PutMapping("update/email/{email}")
	public ResponseEntity<UserResponse> updateUserByEmail(@RequestBody UserRequest userRequest,
			@PathVariable(name = "email") String email) {
		UserResponse userResponse = userService.updateUserByEmail(userRequest, email);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}
	
	@GetMapping("getUserById/{userId}")
	public ResponseEntity<UserResponse> getUsersById(@PathVariable(name = "userId") UUID userId) {
		UserResponse userResponse = userService.getUserById(userId);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}
	@GetMapping("getUserByUserName/{userName}")
	public ResponseEntity<UserResponse> getUsersByUserName(@PathVariable(name = "userName") String userName) {
		UserResponse userResponse = userService.getUserByUserName(userName);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}
	
	@GetMapping("getUserByUserEmail/{email}")
	public ResponseEntity<UserResponse> getUsersByEmail(@PathVariable(name = "email") String email) {
		UserResponse userResponse = userService.getUserByEmail(email);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}
	
	@GetMapping("getAllUsers")
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		List<UserResponse> userResponseList =userService.getAllUsers();
		return new ResponseEntity<>(userResponseList,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/email/{email}")
	public  ResponseEntity<HttpStatus>  deleteUserByEmail(@PathVariable(name = "email") String email) {
		userService.deleteUserByEmail(email);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("delete/userId/{userId}")
	public ResponseEntity<HttpStatus> deleteUserByUUID(@PathVariable(name = "userId") UUID userId) {
		userService.deleteUserById(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("delete/userName/{userName}")
	public ResponseEntity<HttpStatus>  deleteUserByUserName(@PathVariable(name = "userName") String userName) {
		userService.deleteUserByUserName(userName);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
