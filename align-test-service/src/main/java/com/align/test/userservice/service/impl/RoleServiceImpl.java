package com.align.test.userservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.align.test.userservice.entity.Role;
import com.align.test.userservice.repository.RoleRepository;

import com.align.test.userservice.request.RolesRequest;
import com.align.test.userservice.response.RoleResponse;
import com.align.test.userservice.service.RoleService;

@Service
public class RoleServiceImpl  implements RoleService{
	
	  @Autowired
	    RoleRepository roleRepository;

	@Override
	public RoleResponse addRole(RolesRequest rolesRequest) {
		Role role = new Role(rolesRequest);
		return new RoleResponse(roleRepository.save(role));
	}

	@Override
	public RoleResponse getRoleById(Long roleId) {
		Optional<Role> role = roleRepository.findById(roleId);
		return new RoleResponse(role.get());
	}

	@Override
	public RoleResponse getRoleByName(String roleName) {
		//Optional<Role> role = roleRepository.find
		return null;
	}

	@Override
	public List<RoleResponse> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

}
