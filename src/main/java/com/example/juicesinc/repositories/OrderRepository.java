package com.example.juicesinc.repositories;

import com.example.juicesinc.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
