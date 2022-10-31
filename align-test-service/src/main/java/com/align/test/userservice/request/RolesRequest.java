package com.align.test.userservice.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class RolesRequest {

	private long id ;
	private String roleName;
	
	
}
