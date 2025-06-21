package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
