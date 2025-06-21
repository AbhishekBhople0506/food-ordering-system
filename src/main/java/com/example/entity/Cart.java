package com.example.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodItem> foodItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	 // Constructors, getters, and setters
	
	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cart(List<FoodItem> foodItems, Customer customer) {
		super();
		this.foodItems = foodItems;
		this.customer = customer;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}
