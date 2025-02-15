package com.ps.dellclonepro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.dellclonepro.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String u);
}
