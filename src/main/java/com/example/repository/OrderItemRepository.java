package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
