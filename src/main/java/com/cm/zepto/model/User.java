package com.cm.zepto.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	 private int userId;
	 private String userName;
	 private String address;
	 private String emailId;
	 private long mobileNo;
	 
}
