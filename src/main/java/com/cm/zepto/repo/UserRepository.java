package com.cm.zepto.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.zepto.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUserName(String username);
	
	
	
	
	                                                                                          

	
//	public User patchUpdate(int id,User partialUpdate) 
//	{
//		return users.stream().filter(u -> u.getUserId()==id).findFirst()
//				.map(u->
//				{
//				 if(partialUpdate.getUserName()!=null)
//					 u.setUserName(partialUpdate.getUserName());
//				 if(partialUpdate.getAddress()!=null)
//					 u.setAddress(partialUpdate.getAddress());
//				 if(partialUpdate.getEmailId()!=null)
//					 u.setEmailId(partialUpdate.getEmailId());
//				 if(partialUpdate.getMobileNo()!=0)
//					 u.setMobileNo(partialUpdate.getMobileNo());
//				 return u;
//				}).orElse(null);
//	}
}
