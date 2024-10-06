package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.User;
import com.main.repo.UserRepo;

@RestController
public class UserController {

	@Autowired
	UserRepo repo;
	
	@GetMapping("/users")
	public List<User> allusers(){
		List<User> user=repo.findAll();
		return user;
	}
	
	@GetMapping("/user") 
	public User getuser(@PathVariable int id) {
		User a=repo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
		return a;
	}
	
	@PostMapping("/user/add")
	public void addUser(@PathVariable int id,@RequestBody User user) {
		repo.save(user);
	}
	
	@PutMapping("/user/update")
	public User updateUser(@PathVariable int id,@RequestBody User user) {
	User u=repo.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		u=repo.save(u);
		return u;
	}
	
	@DeleteMapping("/user/del")
	public void deleteUser(@PathVariable int id,@RequestBody User u) {
		u=repo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
		repo.delete(u);
	}
}
