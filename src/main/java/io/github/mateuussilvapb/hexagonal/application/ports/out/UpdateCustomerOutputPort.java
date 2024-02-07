package io.github.mateuussilvapb.hexagonal.application.ports.out;

import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
