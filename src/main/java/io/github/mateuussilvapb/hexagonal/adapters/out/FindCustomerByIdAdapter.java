package io.github.mateuussilvapb.hexagonal.adapters.out;

import io.github.mateuussilvapb.hexagonal.adapters.out.repository.CustomerRepository;
import io.github.mateuussilvapb.hexagonal.adapters.out.repository.entity.CustomerEntity;
import io.github.mateuussilvapb.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;
import io.github.mateuussilvapb.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    CustomerEntityMapper customerEntityMapper;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> customerEntity = this.customerRepository.findById(id);
        return customerEntity.map(entity -> this.customerEntityMapper.toCustomer(entity));
    }
}
