package io.github.mateuussilvapb.hexagonal.application.ports.out;

import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
