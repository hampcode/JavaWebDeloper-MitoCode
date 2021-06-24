package com.hampcode.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.model.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	 Users findByUserName(String userName);
}