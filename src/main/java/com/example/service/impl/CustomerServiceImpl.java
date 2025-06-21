package com.example.service.impl;

import com.example.entity.*;
import com.example.repository.*;
import com.example.service.CustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final FoodRepository foodRepository;
    private final OrderRepository orderRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository,
                               FoodRepository foodRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.foodRepository = foodRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Cart createCart(Long customerId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            Cart cart = new Cart();
            cart.setCustomer(customer);
            return cartRepository.save(cart);
        }
        return null;
    }


    @Override
    public Cart addFoodToCart(Long customerId, Long foodId, int quantity) {
        Customer customer = getCustomerById(customerId);
        Food food = foodRepository.findById(foodId).orElse(null);

        if (customer != null && food != null) {
            Cart cart = customer.getOrders().stream()
                    .filter(order -> ((Order) order).getOrderItems().isEmpty()) // Filter for cart (order with no order items)
                    .findFirst()
                    .map(Order::getCart)
                    .orElse(null);		

            if (cart == null) {
                cart = createCart(customerId);
            }

            FoodItem foodItem = new FoodItem();
            foodItem.setFood(food);
            foodItem.setCart(cart);
            foodItem.setQuantity(quantity);
            cart.getFoodItems().add(foodItem);
            return cartRepository.save(cart);
        }
        return null;
    }


    @Override
    public Cart removeFromCart(Long customerId, Long foodItemId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            Cart cart = customer.getOrders().stream()
                    .filter(Order::isCart)
                    .findFirst()
                    .map(Order::getCart)
                    .orElse(null);

            if (cart != null) {
                cart.getFoodItems().removeIf(item -> item.getFood().equals(foodItemId)); // Assuming getFoodItemId() returns the ID of the FoodItem
                return cartRepository.save(cart);
            }
        }
        return null;
    }


    @Override
    public Order placeOrder(Long customerId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            Cart cart = customer.getOrders().stream()
                    .filter(Order::isCart)
                    .findFirst()
                    .map(Order::getCart)
                    .orElse(null);

            if (cart != null && !cart.getFoodItems().isEmpty()) {
                Order order = new Order();
                order.setOrderDate(LocalDateTime.now());
                order.setCustomer(customer);
                order.setCart(cart);
                order.getOrderItems().addAll(cart.getFoodItems().stream()
                        .map(item -> new OrderItem(order, item.getFood(), item.getQuantity()))
                        .toList());
                cart.getFoodItems().clear();
                return orderRepository.save(order);
            }
        }
        return null;
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long customerId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            return customer.getOrders().stream()
                    .filter(order -> !order.isCart())
                    .toList();
        }
        return List.of();
    }

}