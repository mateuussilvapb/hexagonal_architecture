package io.github.mateuussilvapb.hexagonal.adapters.in.consumer;

import io.github.mateuussilvapb.hexagonal.adapters.in.consumer.message.CustomerMessage;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
