package com.example.entity;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

//import com.example.foodorderingsystem.entity.FoodItem;

import jakarta.persistence.*;


@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    private String name;
    private String description;
    private BigDecimal price;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<FoodItem> foodItems = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public Food(String name, String description, BigDecimal price, List<FoodItem> foodItems) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.foodItems = foodItems;
	}

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    // Constructors, getters, and setters
    
}