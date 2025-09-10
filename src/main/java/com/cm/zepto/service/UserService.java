package com.cm.zepto.service;

import java.util.List;
import java.util.Optional;

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
	  userRepo.save(user);
	  return "User added Successfully ";
	}
	
	public Optional<User> findUserById(int id)
	{
		return userRepo.findById(id);
	}
	
	public void deleteUser(int id)
	{
		userRepo.deleteById(id);
	}
//	public String updateUser(int id,User u)
//	{
//		return userRepo.updateUser(id, u);
//	}
	
//	public User patchUpdate(int id,User updatePartial)
//	{
//		return userRepo.patchUpdate(id, updatePartial);
//	}
}
