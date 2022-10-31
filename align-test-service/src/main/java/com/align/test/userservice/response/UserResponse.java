package com.align.test.userservice.response;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.align.test.userservice.entity.Role;
import com.align.test.userservice.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class UserResponse {
	
	private UUID uuid;
	private String userName;
	private String email;
	private String password;
	private List<RoleResponse> rolesResponse;
	
	public UserResponse () {
		
	}
	public UserResponse (User user) {
		this.uuid = user.getUserId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.email = user.getEmail();
		//List<RoleResponse> rolesResponse;
		
		if (user.getRoles() != null) {
			rolesResponse = new ArrayList<RoleResponse>();
			for (Role role: user.getRoles()) {
				rolesResponse.add(new RoleResponse(role));
			}
		}
		
	}

}
