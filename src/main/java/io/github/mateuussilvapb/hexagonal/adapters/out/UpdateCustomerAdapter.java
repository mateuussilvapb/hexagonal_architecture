package io.github.mateuussilvapb.hexagonal.adapters.out;

import io.github.mateuussilvapb.hexagonal.adapters.out.repository.CustomerRepository;
import io.github.mateuussilvapb.hexagonal.adapters.out.repository.entity.CustomerEntity;
import io.github.mateuussilvapb.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;
import io.github.mateuussilvapb.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        CustomerEntity customerEntity = this.customerEntityMapper.toCustomerEntity(customer);
        this.customerRepository.save(customerEntity);
    }
}
