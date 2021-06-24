package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Account;


@Repository
public interface UserRepository extends JpaRepository<Account, Long> {
	 Account findByUserName(String userName);
}
