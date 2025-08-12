package com.firstjobapp.springbootmockmvc;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  boolean existsByName(String name);
}
