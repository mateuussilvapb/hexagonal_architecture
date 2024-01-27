package io.github.mateuussilvapb.hexagonal.adapters.out.client.mapper;

import io.github.mateuussilvapb.hexagonal.adapters.out.client.response.AddressResponse;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
