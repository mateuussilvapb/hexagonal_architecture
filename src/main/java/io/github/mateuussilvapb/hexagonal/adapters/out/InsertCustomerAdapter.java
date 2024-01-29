package io.github.mateuussilvapb.hexagonal.adapters.out;

import io.github.mateuussilvapb.hexagonal.adapters.out.repository.CustomerRepository;
import io.github.mateuussilvapb.hexagonal.adapters.out.repository.entity.CustomerEntity;
import io.github.mateuussilvapb.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;
import io.github.mateuussilvapb.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = this.customerEntityMapper.toCustomerEntity(customer);
        this.customerRepository.save(customerEntity);
    }
}
