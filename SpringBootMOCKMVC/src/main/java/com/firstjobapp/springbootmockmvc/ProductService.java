package com.firstjobapp.springbootmockmvc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductService {
  private final ProductRepository repo;
  public ProductService(ProductRepository repo) { this.repo = repo; }

  public List<Product> findAll() { return repo.findAll(); }
  public Product findById(Long id) {
    return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
  }

  @Transactional
  public Product create(Product p) {
    if (repo.existsByName(p.getName())) {
      throw new IllegalArgumentException("Product name already exists");
    }
    return repo.save(p);
  }

  @Transactional
  public Product update(Long id, Product incoming) {
    Product p = findById(id);
    p.setName(incoming.getName());
    p.setPrice(incoming.getPrice());
    return repo.save(p);
  }

  @Transactional
  public void delete(Long id) {
    if (!repo.existsById(id)) throw new IllegalArgumentException("Product not found: " + id);
    repo.deleteById(id);
  }
}
