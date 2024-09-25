package com.example.juicesinc.repositories;

import com.example.juicesinc.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
