package com.cm.zepto.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int userId;
	 @Column(nullable=false,unique=true)
	 private String userName;
	 private String address;
	 private String emailId;
	 private long mobileNo;
	 @Column(nullable=false)
	 private String password;
	 private boolean enabled=true;
	 @ManyToMany(fetch=FetchType.EAGER)
	 @JoinTable(name="user_roles",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
	 private Set<Role> roles;
	 
	 
	 
	 
}
