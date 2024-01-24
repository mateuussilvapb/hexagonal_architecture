package io.github.mateuussilvapb.hexagonal.application.ports.out;

import io.github.mateuussilvapb.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
