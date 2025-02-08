package com.ps.springbootsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.springbootsecurity.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String s);

}
