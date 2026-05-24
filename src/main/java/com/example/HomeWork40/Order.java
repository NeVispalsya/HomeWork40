package com.example.HomeWork40;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant creationDate;
    private double totalCost;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
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
