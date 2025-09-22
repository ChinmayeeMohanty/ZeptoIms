package com.cm.zepto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
   @Bean
   public BCryptPasswordEncoder passwordEncoder()
   {
	   return new BCryptPasswordEncoder();
   }
   
   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
   {
	   http 
	   	   .csrf(csrf -> csrf.disable())
	   	   .authorizeHttpRequests(auth->auth
	   			   .requestMatchers("/user/**").hasRole("ADMIN")
	   			   
	   			   .requestMatchers(HttpMethod.PUT,"/products/**").hasRole("ADMIN")
	   			   .requestMatchers(HttpMethod.DELETE,"/products/**").hasRole("ADMIN")
	   			   .requestMatchers(HttpMethod.PATCH,"/products/**").hasRole("ADMIN")
	   	           .requestMatchers(HttpMethod.GET,"/products/**").hasAnyRole("ADMIN","USER")
	   	           .requestMatchers(HttpMethod.POST,"/products/**").hasRole("ADMIN")
	   	           .requestMatchers("/**").permitAll()
	   	           .anyRequest().authenticated()
	   	           )
	   	   .httpBasic(Customizer.withDefaults())
	   	   .formLogin(form-> form.disable())
	   	   .logout(logout->logout.permitAll());
	   return http.build();
   }
}
