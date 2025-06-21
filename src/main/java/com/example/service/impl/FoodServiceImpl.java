package com.example.service.impl;

import com.example.entity.Food;
import com.example.repository.FoodRepository;
import com.example.service.FoodService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService{

	private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food getFoodById(Long foodId) {
        Optional<Food> optionalFood = foodRepository.findById(foodId);
        return optionalFood.orElse(null);
    }

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public Food updateFood(Long foodId, Food updatedFood) {
        Optional<Food> optionalFood = foodRepository.findById(foodId);
        if (optionalFood.isPresent()) {
            Food food = optionalFood.get();
            food.setName(updatedFood.getName());
            food.setDescription(updatedFood.getDescription());
            food.setPrice(updatedFood.getPrice());
            return foodRepository.save(food);
        }
        return null;
    }

    @Override
    public void deleteFood(Long foodId) {
        foodRepository.deleteById(foodId);
    }
}
