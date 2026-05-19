package com.example.HomeWork40;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class Order {
    private Long id;
    private Instant creationDate;
    private double totalCost;
    private List<Product> products;

    public Order(Long id, List<Product> products) {
        this.id = id;
        this.creationDate = Instant.now();
        this.products = products;
    }

    public Order() {
        this.creationDate = Instant.now();
    }
}
