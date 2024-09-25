package com.example.juicesinc.repositories;

import com.example.juicesinc.models.RawMaterial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialRepository extends MongoRepository<RawMaterial, String> {
}
