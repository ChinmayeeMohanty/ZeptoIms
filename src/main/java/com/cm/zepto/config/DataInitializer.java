package com.cm.zepto.config;

import java.util.Set;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cm.zepto.model.Role;
import com.cm.zepto.model.User;
import com.cm.zepto.repo.RoleRepository;
import com.cm.zepto.repo.UserRepository;

@Configuration
public class DataInitializer {

	@Bean
	CommandLineRunner init(RoleRepository roleRepo,UserRepository userRepo,BCryptPasswordEncoder encoder)
	{
		return args -> {
			Role adminRole=roleRepo.findByName("ROLE_ADMIN")
					.orElseGet(()-> roleRepo.save(new Role(null,"ROLE_ADMIN")));
			Role userRole=roleRepo.findByName("ROLE_USER")
					.orElseGet(()-> roleRepo.save(new Role(null,"ROLE_USER")));
			
			if (userRepo.findByUserName("admin").isEmpty())
			{
				User admin=new User();
				admin.setUserName("admin");
				admin.setPassword(encoder.encode("admin123"));
				admin.setRoles(Set.of(adminRole));
				admin.setEnabled(true);
				userRepo.save(admin);
			}
			
			if (userRepo.findByUserName("rima").isEmpty())
			{
				User user1=new User();
				user1.setUserName("rima");
				user1.setPassword(encoder.encode("rima123"));
				user1.setRoles(Set.of(userRole));
				user1.setEnabled(true);
				userRepo.save(user1);
			}

		};
	}
	
}
