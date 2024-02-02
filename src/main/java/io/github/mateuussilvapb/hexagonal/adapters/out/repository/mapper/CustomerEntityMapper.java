package io.github.mateuussilvapb.hexagonal.adapters.out.repository.mapper;

import io.github.mateuussilvapb.hexagonal.adapters.out.repository.entity.CustomerEntity;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
