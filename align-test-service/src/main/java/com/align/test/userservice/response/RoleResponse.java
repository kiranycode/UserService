package com.align.test.userservice.response;


import java.util.UUID;

import com.align.test.userservice.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
public class RoleResponse {
	
	
	
	private long id;
	private String roleName;
	@JsonIgnore
	private UUID userId;
	

	public RoleResponse (Role role) {
		this.id = role.getRoleId();
		this.roleName =role.getRoleName();

	}
	
	public RoleResponse (UUID userId, String roleName) {
		this.userId = userId;
		this.roleName =roleName;
	}
	
	public RoleResponse (UUID userId) {
		this.userId = userId;
	}
	

}
