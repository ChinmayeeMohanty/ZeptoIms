package com.cm.zepto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cm.zepto.model.User;
import com.cm.zepto.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:5173" )
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("/{uid}")
	public  Optional<User> getUserById(@PathVariable("uid") int id)
	{
		return userService.findUserById(id);
	}
	
	@PostMapping("/")
	public String addUser(@RequestBody User u)
	{
	return userService.addUser(u);
	}
	
	@DeleteMapping("/{uid}")
	public void deleteUser(@PathVariable("uid") int id)
	{
		 userService.deleteUser(id);
	}
//	@PutMapping("/{uid}")
//	public String updateUser(@PathVariable("uid") int id,@RequestBody User u)
//	{
//		return userService.updateUser(id, u);
//	}
//	
//	@PatchMapping("/{uid}")
//	public User patchUpdate(@PathVariable("uid") int id,@RequestBody User u)
//	{
//		return userService.patchUpdate(id, u);
//	}
}
