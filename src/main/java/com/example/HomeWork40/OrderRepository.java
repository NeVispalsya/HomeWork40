package com.example.HomeWork40;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@Repository
public class OrderRepository {
    private AtomicLong idGenerator = new AtomicLong(0);
    private Map<Long,Order> orders = new ConcurrentHashMap<>();

    public Order saveOrder(List<Product> products){
        Long newId = idGenerator.incrementAndGet();
        Order order = new Order();
        order.setId(newId);
        order.setProducts(products);
        double sum = 0;
        if (products != null) {
            for (Product product : products) {
                sum += product.getCost();
            }
        }
        order.setTotalCost(sum);
        orders.put(newId,order);
        return order;
    }
    public List<Order> findAll(){
        return new ArrayList<>(orders.values());
    }
    public Order findOrderById(Long id){
        Order order = orders.get(id);
        if(order==null){
            throw new RuntimeException("Order not found");
        }
        return order;
    }

}
