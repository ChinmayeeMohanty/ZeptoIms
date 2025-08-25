package com.cm.zepto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.zepto.model.User;
import com.cm.zepto.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService UserService;
	
	@GetMapping("/user")
	public List<User> getAllUsers()
	{
		return UserService.getAllUsers();
	}
	
	@GetMapping("/user/{uid}")
	public  User getUserById(@PathVariable int id)
	{
		return UserService.findById(id);
	}
	
	@PostMapping("/user")
	public String addUser(@RequestBody User u)
	{
	return UserService.addUser(u);
	}
	
	@DeleteMapping("/user/{uid}")
	public String deleteUser(@PathVariable int id)
	{
		return UserService.deleteUser(id);
	}
	@PutMapping("/user/{uid}")
	public String updateUser(@PathVariable int id,@RequestBody User u)
	{
		return UserService.updateUser(id, u);
	}
	
	@PatchMapping("/user/{uid}")
	public User patchUpdate(@PathVariable int id,@RequestBody User u)
	{
		return UserService.PatchUpdate(id, u);
	}
}
