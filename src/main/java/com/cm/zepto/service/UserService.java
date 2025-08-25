package com.cm.zepto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.zepto.model.User;
import com.cm.zepto.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers()
	{
		return userRepo.findAll();
	}
	
	public String addUser(User user)
	{
	  userRepo.addUser(user);
	  return "User added Successfully ";
	}
	
	public User findById(int id)
	{
		return userRepo.findById(id);
	}
	public String updateUser(int id,User u)
	{
		return userRepo.updateUser(id, u);
	}
	public String deleteUser(int id)
	{
		return userRepo.removeUser(id);
	}
	public User PatchUpdate(int id,User updatePartial)
	{
		return userRepo.patchUpdate(id, updatePartial);
	}
}
