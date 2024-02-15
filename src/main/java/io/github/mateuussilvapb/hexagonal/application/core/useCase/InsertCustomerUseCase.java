package io.github.mateuussilvapb.hexagonal.application.core.useCase;

import io.github.mateuussilvapb.hexagonal.application.core.domain.Address;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;
import io.github.mateuussilvapb.hexagonal.application.ports.in.InsertCustomerInputPort;
import io.github.mateuussilvapb.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import io.github.mateuussilvapb.hexagonal.application.ports.out.InsertCustomerOutputPort;
import io.github.mateuussilvapb.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort
    ) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        Address address = this.findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        this.insertCustomerOutputPort.insert(customer);
        this.sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
