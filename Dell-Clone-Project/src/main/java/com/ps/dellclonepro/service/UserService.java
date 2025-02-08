package com.ps.dellclonepro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dellclonepro.entity.User;
import com.ps.dellclonepro.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email); 
    }
}
