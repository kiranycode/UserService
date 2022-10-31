package com.align.test.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.align.test.userservice.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
	
	public Role findByRoleName(String rolename);

}
