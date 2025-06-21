package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.FoodItem;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long>{

}
