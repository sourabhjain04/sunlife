package com.springrestjdbc.service;


import com.springrestjdbc.model.Product;
import com.springrestjdbc.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ProductService {

    private final ProductRepository repo;


    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll(){
        return repo.findAll();
    }

    public Product getById(Long id) {
        return repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Product not found: " + id));
    }

    public Product create(Product p) {
        return repo.save(p);
    }

    public Product update(Long id, Product p) {
        getById(id);
        repo.update(id,p);
        p.setId(id);
        return p;


    }

    public void delete(Long id) {
        getById(id);
        repo.delete(id);
    }


}
