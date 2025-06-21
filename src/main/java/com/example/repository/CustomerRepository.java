package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
