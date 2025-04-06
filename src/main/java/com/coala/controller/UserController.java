package com.coala.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coala.model.User;
import com.coala.service.UserService;

import jakarta.servlet.Servlet;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser( @RequestBody User user) {
		User userSave = userService.create(user);
		if(userSave != null) {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(userSave.getIdUser())
					.toUri();
			
			return ResponseEntity.created(location).body(userSave);
		}
		return ResponseEntity.badRequest().body("o cliente ja é cadastrado");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdUser(@PathVariable Long id) {
		User user = userService.findByIdUser(id);
		if(user != null) {
			return ResponseEntity.ok(user);
		}
		
		return ResponseEntity.badRequest().body("Cliente nao econtrado");
		
	}
}
