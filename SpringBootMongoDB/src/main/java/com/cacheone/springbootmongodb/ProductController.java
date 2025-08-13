package com.cacheone.springbootmongodb;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService service;
  public ProductController(ProductService service) { this.service = service; }

  @GetMapping
  public List<Product> all() { return service.list(); }

  @GetMapping("/{id}")
  public Product one(@PathVariable String id) { return service.get(id); }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Product create(@Valid @RequestBody Product p) { return service.create(p); }

  @PatchMapping("/{id}")
  public Product patch(@PathVariable String id, @RequestBody Product updates) { return service.update(id, updates); }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable String id) { service.delete(id); }

  // Extras: filter endpoints
  @GetMapping("/category/{category}")
  public List<Product> byCategory(@PathVariable String category) { return service.byCategory(category); }
}
