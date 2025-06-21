package com.example.service;


import java.util.List;

import com.example.entity.Food;

public interface FoodService {

	 Food createFood(Food food);
	 Food getFoodById(Long foodId);
	 List<Food> getAllFoods();
	 Food updateFood(Long foodId, Food updatedFood);
	 void deleteFood(Long foodId);
}
