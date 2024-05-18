package com.example.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class Controller {
	@Autowired
	private User userRepository;

	@GetMapping
	public List<User> getAllUsers() {
	    return userRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
	    User savedUser = userRepository.save(user);
	    return ResponseEntity.ok(savedUser);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable UUID id) {
	    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));
	    return ResponseEntity.ok(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable UUID id, @Valid @RequestBody User userDetails) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));

	    user.setFullName(userDetails.getFullName());
	    user.setMobileNumber(userDetails.getMobileNumber());
	    user.setPanNumber(userDetails.getPanNumber());
	    user.setManagerId(userDetails.getManagerId());

	    User updatedUser = userRepository.save(user);
	    return ResponseEntity.ok(updatedUser);
}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
	    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));
	    userRepository.delete(user);
	    return ResponseEntity.noContent().build();
	}
}



