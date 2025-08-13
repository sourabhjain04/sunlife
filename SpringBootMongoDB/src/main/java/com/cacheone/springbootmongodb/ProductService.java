package com.cacheone.springbootmongodb;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ProductService {
  private final ProductRepository repo;
  public ProductService(ProductRepository repo) { this.repo = repo; }

  public List<Product> list() { return repo.findAll(); }

  public Product get(String id) {
    return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
  }

  public Product create(Product p) {
    Assert.hasText(p.getName(), "name is required");
    return repo.save(p);
  }

  public Product update(String id, Product updates) {
    Product existing = get(id);
    if (updates.getName() != null && !updates.getName().isBlank()) existing.setName(updates.getName());
    if (updates.getCategory() != null) existing.setCategory(updates.getCategory());
    if (updates.getPrice() >= 0) existing.setPrice(updates.getPrice());
    return repo.save(existing);
  }

  public void delete(String id) { repo.deleteById(id); }

  public List<Product> byCategory(String category) { return repo.findByCategoryIgnoreCase(category); }
}
