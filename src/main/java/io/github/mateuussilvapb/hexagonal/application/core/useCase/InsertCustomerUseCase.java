package io.github.mateuussilvapb.hexagonal.application.core.useCase;

import io.github.mateuussilvapb.hexagonal.application.core.domain.Address;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;
import io.github.mateuussilvapb.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import io.github.mateuussilvapb.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort
    ) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    public void insert(Customer customer, String zipCode) {
        Address address = this.findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        this.insertCustomerOutputPort.insert(customer);
    }
}
