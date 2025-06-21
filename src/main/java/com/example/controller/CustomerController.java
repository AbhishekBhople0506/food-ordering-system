package com.example.controller;

import com.example.entity.Cart;

import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	    @Autowired
	    private CustomerService customerService;

	    @PostMapping
	    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	        Customer createdCustomer = customerService.createCustomer(customer);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
	    }

	    @GetMapping("/{customerId}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
	        Customer customer = customerService.getCustomerById(customerId);
	        return ResponseEntity.ok(customer);
	    }

	    @GetMapping
	    public ResponseEntity<List<Customer>> getAllCustomers() {
	        List<Customer> customers = customerService.getAllCustomers();
	        return ResponseEntity.ok(customers);
	    }

	    @PostMapping("/{customerId}/cart")
	    public ResponseEntity<Cart> createCart(@PathVariable Long customerId) {
	        Cart cart = customerService.createCart(customerId);
	        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
	    }

	    @PostMapping("/{customerId}/cart/{foodId}")
	    public ResponseEntity<Cart> addFoodToCart(@PathVariable Long customerId, @PathVariable Long foodId, @RequestParam int quantity) {
	        Cart updatedCart = customerService.addFoodToCart(customerId, foodId, quantity);
	        return ResponseEntity.ok(updatedCart);
	    }

	    @DeleteMapping("/{customerId}/cart/{foodItemId}")
	    public ResponseEntity<Cart> removeFromCart(@PathVariable Long customerId, @PathVariable Long foodItemId) {
	        Cart updatedCart = customerService.removeFromCart(customerId, foodItemId);
	        return ResponseEntity.ok(updatedCart);
	    }

	    @PostMapping("/{customerId}/orders")
	    public ResponseEntity<Order> placeOrder(@PathVariable Long customerId) {
	        Order order = customerService.placeOrder(customerId);
	        return ResponseEntity.status(HttpStatus.CREATED).body(order);
	    }

	    @GetMapping("/{customerId}/orders")
	    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable Long customerId) {
	        List<Order> orders = customerService.getOrdersByCustomerId(customerId);
	        return ResponseEntity.ok(orders);
	    }
}
