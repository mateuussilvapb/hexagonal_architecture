package io.github.mateuussilvapb.hexagonal.application.ports.in;

public interface DeleteCustomerByIdInputPort {

    void delete(String id);
}
