package io.github.mateuussilvapb.hexagonal.application.ports.in;

import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
