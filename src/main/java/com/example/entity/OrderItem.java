package com.example.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    private int quantity;

    // Constructors, getters, and setters

    
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderItem(Order order, Food food, int quantity) {
		super();
		this.order = order;
		this.food = food;
		this.quantity = quantity;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

}
