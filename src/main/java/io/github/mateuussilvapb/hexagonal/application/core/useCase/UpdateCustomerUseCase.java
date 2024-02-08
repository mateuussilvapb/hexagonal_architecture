package io.github.mateuussilvapb.hexagonal.application.core.useCase;

import io.github.mateuussilvapb.hexagonal.application.core.domain.Address;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;
import io.github.mateuussilvapb.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import io.github.mateuussilvapb.hexagonal.application.ports.in.UpdateCustomerInputPort;
import io.github.mateuussilvapb.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import io.github.mateuussilvapb.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        this.findCustomerByIdInputPort.find(customer.getId());
        Address address = this.findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        this.updateCustomerOutputPort.update(customer);

    }
}
