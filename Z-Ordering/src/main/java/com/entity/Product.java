package com.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    private Long productId;

    private String name;
    private double price;

    public Product() {}

    public Product(Long productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
