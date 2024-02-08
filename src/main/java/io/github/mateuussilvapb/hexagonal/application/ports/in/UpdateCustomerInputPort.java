package io.github.mateuussilvapb.hexagonal.application.ports.in;

import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    public void update(Customer customer, String zipCode);
}
