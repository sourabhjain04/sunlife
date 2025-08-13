package com.cacheone.springbootmongodb;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
  @Id
  private String id;

  @NotBlank
  @Indexed(unique = true)   // creates a unique index on "name"
  private String name;

  @Min(0)
  private double price;

  private String category;

  public Product() {}
  public Product(String name, double price, String category) {
    this.name = name; this.price = price; this.category = category;
  }

  // getters/setters
  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public double getPrice() { return price; }
  public void setPrice(double price) { this.price = price; }
  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }
}
