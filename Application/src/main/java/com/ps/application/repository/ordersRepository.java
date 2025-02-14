package com.ps.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.application.entity.Orders;

public interface ordersRepository extends JpaRepository<Orders, Integer> {

}
