package com.align.test.userservice.service;

import java.util.List;
import java.util.UUID;

import com.align.test.userservice.request.UserRequest;
import com.align.test.userservice.response.UserResponse;

public interface UserService {

	
	public UserResponse addUser(UserRequest userRequest);

	
    public void deleteUserById(UUID userId);
    public void deleteUserByUserName(String userName);
    public void deleteUserByEmail(String email);
    

	public UserResponse updateUserByUserName(UserRequest userRequest, String userName);
	public UserResponse updateUserByEmail(UserRequest userRequest, String email);
	public UserResponse updateUserByUUID(UserRequest userRequest, UUID userId);
	
	
	
    public UserResponse getUserById(UUID userId);
    public List<UserResponse> getAllUsers();
    public UserResponse getUserByUserName(String userName);
    public UserResponse getUserByEmail(String email);
    
}
