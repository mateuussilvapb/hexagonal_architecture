package io.github.mateuussilvapb.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOutputPort {
    public void delete(String id);
}
