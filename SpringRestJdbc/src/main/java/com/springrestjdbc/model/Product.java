package com.springrestjdbc.model;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Product {
    private Long id;

    @NotBlank
    private String name;
    @NotNull @Min(0)
    private Double price;
    @NotNull @Min(0)
    private Integer qty;

    public Product() {}

    public Product(Long id, String name, Double price, Integer qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Integer getQty() { return qty; }
    public void setQty(Integer qty) { this.qty = qty; }
}