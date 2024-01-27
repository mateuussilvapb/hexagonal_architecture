package io.github.mateuussilvapb.hexagonal.adapters.out;

import io.github.mateuussilvapb.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import io.github.mateuussilvapb.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import io.github.mateuussilvapb.hexagonal.adapters.out.client.response.AddressResponse;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Address;
import io.github.mateuussilvapb.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = this.findAddressByZipCodeClient.find(zipCode);
        return this.addressResponseMapper.toAddress(addressResponse);
    }
}
