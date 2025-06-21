package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
