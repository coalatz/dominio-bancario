package com.coala.service;

import com.coala.model.User;

public interface UserService {

	User findByIdUser(Long id);
	
	User create(User user);
}
