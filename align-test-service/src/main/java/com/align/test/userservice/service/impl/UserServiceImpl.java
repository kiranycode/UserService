package com.align.test.userservice.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.align.test.userservice.entity.Role;
import com.align.test.userservice.entity.User;
import com.align.test.userservice.repository.RoleRepository;
import com.align.test.userservice.repository.UserRepository;
import com.align.test.userservice.request.RolesRequest;
import com.align.test.userservice.request.UserRequest;
import com.align.test.userservice.response.UserResponse;
import com.align.test.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;



	@Override
	public void deleteUserById(UUID userId) {
		userRepository.deleteById(userId);

	}

	@Override
	public void deleteUserByUserName(String userName) {
		Optional<User> user = userRepository.findByUserNameIgnoreCase(userName);
		userRepository.delete(user.get());
	}

	@Override
	public void deleteUserByEmail(String email) {
		Optional<User> user = userRepository.findByEmailIgnoreCase(email);
		userRepository.delete(user.get());
	}

	@Override
	public UserResponse getUserById(UUID userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return  new UserResponse(user.get());
		}else {
			return new UserResponse();
		}
	}

	@Override
	public List<UserResponse> getAllUsers() {
		List<User> userList = userRepository.findAll();
		return converToUSerResponse(userList);
	}
	
	
	
	@Override
	public UserResponse getUserByUserName(String userName) {
		Optional<User> user = userRepository.findByUserNameIgnoreCase(userName);
		return   new UserResponse(user.get());
	}
	
	@Override
	public UserResponse getUserByEmail(String email) {
		Optional<User> user = userRepository.findByEmailIgnoreCase(email);
		return   new UserResponse(user.get());
	}
	
	

	@Override
	public UserResponse updateUserByUserName(UserRequest userRequest, String userName) {
		Optional<User> user = userRepository.findByUserNameIgnoreCase(userName);
		User updateUser = new User(userRequest);
		updateUser.setUserId(user.get().getUserId());
		return new UserResponse(userRepository.save(updateUser));
	}

	
	
	@Override
	public UserResponse updateUserByEmail(UserRequest userRequest, String email) {
		Optional<User> user = userRepository.findByEmailIgnoreCase(email);
		User updateUser = new User(userRequest);
		updateUser.setUserId(user.get().getUserId());
		return new UserResponse(userRepository.save(updateUser));
	}

	@Override
	public UserResponse updateUserByUUID(UserRequest userRequest, UUID userId) {
		Optional<User> user = userRepository.findById(userId);
		User updateUser = new User(userRequest);
		updateUser.setUserId(user.get().getUserId());
		return new UserResponse(userRepository.save(updateUser));
	}

	@Override
	public UserResponse addUser(UserRequest userRequest) {
		User user = new User(userRequest);
	//	User u = userRepository.save(user);
		Set<Role> roleList = new HashSet<Role>();
		if (userRequest.getRolesRequest() != null) {
			for (RolesRequest rolesRequest : userRequest.getRolesRequest()) {
				Optional<Role> roleOptional = roleRepository.findById(rolesRequest.getId());

				if(roleOptional.isPresent()){
					roleList.add( roleOptional.get());
				}else{
					roleList.add(new Role());
				}
			}
			user.setRoles(roleList);
		}
		UserResponse userResponse= new UserResponse(userRepository.save(user));
		return userResponse;
	}
	
	
	private  List<UserResponse> converToUSerResponse(List<User> userList ){
		List<UserResponse> userResponseList= new ArrayList<>();
		for(User user: userList) {
			UserResponse userResponse = new UserResponse(user);
			userResponseList.add(userResponse);
		}
		return userResponseList;
	}
	
	

}
