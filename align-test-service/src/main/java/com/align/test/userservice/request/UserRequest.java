package com.align.test.userservice.request;


import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

	private UUID userId;
	private String userName;
	private String password;
	private String email;
	private List<RolesRequest> rolesRequest;

}