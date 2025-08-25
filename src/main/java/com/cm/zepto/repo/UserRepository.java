package com.cm.zepto.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cm.zepto.model.User;
@Repository
public class UserRepository {

	List<User> users=new ArrayList<User>(
			Arrays.asList(
					new User(1,"Chinmayee","Hyderabad","chinmayee@gmail.com",7979797900L),
					new User(2,"SibaSundar","Bhubaneswar","sibasundar@gmail.com",1234567780L),
					new User(3,"Sanjay","Rourkela","sanjay@gmail.com",2113345689L),
					new User(4,"Minati","Jagatsinghpur","minati@gmail.com",7897889678L),
					new User(5,"Sonali","Jagatsinghpur","sonali@gmail.com",8989890000L)
					));
	
	int idCounter=6;
	public List<User> findAll()
	{
		return users;
	}
	public void addUser(User user)
	{
		user.setUserId(idCounter++);
		users.add(user);
	}
	public User findById(int id)
	{
		return users.stream().filter(u -> u.getUserId()== id).findFirst().orElse(null);
	}
	public String updateUser(int id,User updatedUser) 
	{
		boolean found=users.stream().filter(u-> u.getUserId()==id)
				.peek(p-> {p.setUserId(updatedUser.getUserId());
		p.setUserName(updatedUser.getUserName());
		p.setAddress(updatedUser.getAddress());
		p.setEmailId(updatedUser.getEmailId());
		p.setMobileNo(updatedUser.getMobileNo());})
		.findFirst().isPresent();
		
				
	
		return found ?"User Updated":"User not found";
	}
	public String removeUser(int id) 
	{
		boolean removed=users.removeIf(u -> u.getUserId()==id);
		return removed?"User deleted":"User not found";
	}
	public User patchUpdate(int id,User partialUpdate) 
	{
		return users.stream().filter(u -> u.getUserId()==id).findFirst()
				.map(u->
				{
				 if(partialUpdate.getUserName()!=null)
					 u.setUserName(partialUpdate.getUserName());
				 if(partialUpdate.getAddress()!=null)
					 u.setAddress(partialUpdate.getAddress());
				 if(partialUpdate.getEmailId()!=null)
					 u.setEmailId(partialUpdate.getEmailId());
				 if(partialUpdate.getMobileNo()!=0)
					 u.setMobileNo(partialUpdate.getMobileNo());
				 return u;
				}).orElse(null);
	}
}
