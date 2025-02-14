package com.ps.dellclonepro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ps.dellclonepro.entity.User;
import com.ps.dellclonepro.repository.UserRepository;


public class MySetUserDetailsServiceNew implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User does not exist");
		
		return new MyUserDecorator(user);
	}

}