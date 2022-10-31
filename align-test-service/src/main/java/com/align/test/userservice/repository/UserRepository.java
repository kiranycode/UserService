package com.align.test.userservice.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.align.test.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
	
	Optional<User>  findByUserNameIgnoreCase(String userName);

	Optional<User> findByEmailIgnoreCase(String email);

}
