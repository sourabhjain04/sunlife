package com.cacheone.springbootmongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
  Optional<Product> findByName(String name);
  List<Product> findByCategoryIgnoreCase(String category);
  List<Product> findByPriceBetween(double min, double max);

  @Query("{'price':{$gte:?0, $lte:?1},'category':?2}")

  @Query("{'_id':?0}")
  @Update("{$set: {'price': ?1}}")

}
