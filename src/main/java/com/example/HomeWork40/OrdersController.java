package com.example.HomeWork40;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderRepository repository;

    public OrdersController(OrderRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Order> getAllOrders() {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable Long id){
       return repository.findOrderById(id);
    }
    @PostMapping
    public Order createOrder(@RequestBody List<Product> products) {
        return repository.saveOrder(products);
    }
}
