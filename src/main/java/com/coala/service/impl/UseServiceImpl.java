package com.coala.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coala.model.User;
import com.coala.respository.UserRepository;
import com.coala.service.UserService;

@Service
public class UseServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findByIdUser(Long id) {
		 Optional<User> userEncontrado = userRepository.findById(id);
		 if(userEncontrado.isPresent()) {
			 return userEncontrado.get();
		 }
		 return null;
		 
	}

	@Override
	public User create(User user) {
		if(user.getIdUser() != null && userRepository.existsById(user.getIdUser())) {
			return null;
		}
		userRepository.save(user);
		return user;
	}

}
