package com.example.HomeWork40;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderSerice {
    private final OrderRepository repository;
    public List<Order> findAll(){
        return repository.findAll();
    }
    public Order findOrderById(Long id){
        Optional<Order> order = repository.findById(id);
        if(order.isPresent()){
            return order.get();
        }else{
            throw new RuntimeException("order not found");
        }
    }
    public Order saveOrder(List<Product> products){
        Order order = new Order();
        order.setProducts(products);
        double sum = 0;
        if (products != null) {
            for (Product product : products) {
                sum += product.getCost();
            }
        }
        order.setTotalCost(sum);
        return repository.save(order);
    }
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
    public Order updateOrder(Long id, List<Product> products) {
        Order order = findOrderById(id);
        order.setProducts(products);
        double sum = 0;
        if (products != null) {
            for (Product product : products) {
                sum += product.getCost();
            }
        }
        order.setTotalCost(sum);
        return repository.save(order);
    }
}
