package com.example.service;

import java.util.List;

import com.example.entity.Cart;
import com.example.entity.Customer;
import com.example.entity.Order;

public interface CustomerService {

	
	Customer createCustomer(Customer customer);
    Customer getCustomerById(Long customerId);
    List<Customer> getAllCustomers();
    Cart createCart(Long customerId);
    Cart addFoodToCart(Long customerId, Long foodId, int quantity);
    Cart removeFromCart(Long customerId, Long foodItemId);
    Order placeOrder(Long customerId);
    List<Order> getOrdersByCustomerId(Long customerId);
}
