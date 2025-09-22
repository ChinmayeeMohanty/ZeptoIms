package com.cm.zepto.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cm.zepto.model.User;
import com.cm.zepto.repo.UserRepository;

@Service
public class UserService implements UserDetailsService {

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
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user =userRepo.findByUserName( username).orElseThrow(()->new UsernameNotFoundException("user not found"));
		var authorities=user.getRoles().stream().map(r->new org.springframework.security.core.authority.SimpleGrantedAuthority(r.getName())).collect(Collectors.toSet());
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),user.isEnabled(),true,true,true,authorities);
	}
}
