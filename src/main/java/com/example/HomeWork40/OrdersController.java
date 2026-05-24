package com.example.HomeWork40;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrderSerice serice;
    public OrdersController(OrderSerice orderSerice) {
        this.serice = orderSerice;
    }
    @GetMapping
    public List<Order> getAllOrders() {
        return serice.findAll();
    }
    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable Long id){
       return serice.findOrderById(id);
    }
    @PostMapping
    public Order createOrder(@RequestBody List<Product> products) {
        return serice.saveOrder(products);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        serice.deleteOrder(id);
    }
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody List<Product> products) {
        return serice.updateOrder(id, products);
    }
}
