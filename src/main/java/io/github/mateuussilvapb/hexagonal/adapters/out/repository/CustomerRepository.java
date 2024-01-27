package io.github.mateuussilvapb.hexagonal.adapters.out.repository;

import io.github.mateuussilvapb.hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
