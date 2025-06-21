package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();
    
    @ManyToOne
    private Cart cart;
    
    private boolean isCart;

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public boolean isCart() {
		return isCart;
	}

	public void setCart(boolean isCart) {
		this.isCart = isCart;
	}

	public Order(LocalDateTime orderDate, Customer customer, List<OrderItem> orderItems, Cart cart, boolean isCart) {
		super();
		this.orderDate = orderDate;
		this.customer = customer;
		this.orderItems = orderItems;
		this.cart = cart;
		this.isCart = isCart;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
