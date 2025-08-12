package com.firstjobapp.springbootmockmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductApiIT {

  @Autowired
  MockMvc mockMvc;
  @Autowired
  ObjectMapper objectMapper;
  @Autowired
  ProductRepository repo;

  @BeforeEach
  void cleanDb() {
    repo.deleteAll();
  }

  @Test
  void create_and_fetch_product() throws Exception {
    Product payload = Product.builder().name("Laptop").price(85000).build();

    // Create
    mockMvc.perform(post("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(payload)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id", notNullValue()))
        .andExpect(jsonPath("$.name").value("Laptop"))
        .andExpect(jsonPath("$.price").value(85000.0));

    // List
    mockMvc.perform(get("/api/products"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].name").value("Laptop"));
  }

  @Test
  void validation_failure_on_blank_name() throws Exception {
    Product payload = Product.builder().name("").price(100).build(); // @NotBlank fails

    mockMvc.perform(post("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(payload)))
        .andExpect(status().isBadRequest()); // Spring Validation triggers 400 automatically
  }

  @Test
  void update_then_get_by_id() throws Exception {
    // seed one product
    Product saved = repo.save(Product.builder().name("Mouse").price(1200).build());

    Product update = Product.builder().name("Gaming Mouse").price(2500).build();

    mockMvc.perform(put("/api/products/{id}", saved.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(update)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Gaming Mouse"))
        .andExpect(jsonPath("$.price").value(2500.0));

    mockMvc.perform(get("/api/products/{id}", saved.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Gaming Mouse"));
  }

  @Test
  void delete_product() throws Exception {
    Product saved = repo.save(Product.builder().name("Keyboard").price(3000).build());

    mockMvc.perform(delete("/api/products/{id}", saved.getId()))
        .andExpect(status().isNoContent());

    mockMvc.perform(get("/api/products/{id}", saved.getId()))
        .andExpect(status().isInternalServerError()); // due to IllegalArgumentException in service
  }
}
