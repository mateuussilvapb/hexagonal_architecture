package io.github.mateuussilvapb.hexagonal.config;

import io.github.mateuussilvapb.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import io.github.mateuussilvapb.hexagonal.adapters.out.FindCustomerByIdAdapter;
import io.github.mateuussilvapb.hexagonal.adapters.out.InsertCustomerAdapter;
import io.github.mateuussilvapb.hexagonal.application.core.useCase.FindCustomerByIdUseCase;
import io.github.mateuussilvapb.hexagonal.application.core.useCase.InsertCustomerUseCase;
import io.github.mateuussilvapb.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
