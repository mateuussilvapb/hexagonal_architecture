package io.github.mateuussilvapb.hexagonal.application.ports.in;

import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
