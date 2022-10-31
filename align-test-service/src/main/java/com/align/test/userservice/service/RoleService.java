package com.align.test.userservice.service;



import java.util.List;

import com.align.test.userservice.request.RolesRequest;
import com.align.test.userservice.response.RoleResponse;


public interface RoleService {

	RoleResponse addRole(RolesRequest rolesRequest);
	RoleResponse getRoleById(Long roleId);
	RoleResponse getRoleByName(String roleName);
	List<RoleResponse> getAllRoles();

}
