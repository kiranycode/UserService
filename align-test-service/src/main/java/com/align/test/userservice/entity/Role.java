package com.align.test.userservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.align.test.userservice.request.RolesRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "ROLE")
public class Role {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;

	@Column(name = "ROLENAME",nullable = false)
	private String roleName;
	
	
	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Role(long id) {
		this.roleId = id;
	}


	public Role(RolesRequest rolesRequest) {
		this.roleName=rolesRequest.getRoleName();
	}
	
	@Override
	public String toString() {
		return this.roleName;
	}

}
