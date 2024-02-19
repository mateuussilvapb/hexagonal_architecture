package io.github.mateuussilvapb.hexagonal.adapters.in.controller.mapper;

import io.github.mateuussilvapb.hexagonal.adapters.in.controller.request.CustomerRequest;
import io.github.mateuussilvapb.hexagonal.adapters.in.controller.response.CustomerResponse;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "CPFValid", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
