package com.example.controller;

import com.example.entity.Food;

import com.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

	@Autowired
    private FoodService foodService;

    @PostMapping("/created")
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        Food createdFood = foodService.createFood(food);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFood);
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long foodId) {
        Food food = foodService.getFoodById(foodId);
        return ResponseEntity.ok(food);
    }

    @GetMapping("/Get all")
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = foodService.getAllFoods();
        return ResponseEntity.ok(foods);
    }

    @PutMapping("/{foodId}")
    public ResponseEntity<Food> updateFood(@PathVariable Long foodId, @RequestBody Food updatedFood) {
        Food food = foodService.updateFood(foodId, updatedFood);
        return ResponseEntity.ok(food);
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long foodId) {
        foodService.deleteFood(foodId);
        return ResponseEntity.noContent().build();
    }
}
