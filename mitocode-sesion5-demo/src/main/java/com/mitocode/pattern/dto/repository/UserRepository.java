package com.mitocode.pattern.dto.repository;

import java.util.ArrayList;
import java.util.List;

import com.mitocode.pattern.dto.entity.User;

public class UserRepository {

	public List<User> findAllUsers(){
		List<User> users=new ArrayList<>();
		return users;
	}
}
