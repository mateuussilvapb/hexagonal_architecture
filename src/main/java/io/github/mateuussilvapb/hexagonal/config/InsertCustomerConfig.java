package io.github.mateuussilvapb.hexagonal.config;

import io.github.mateuussilvapb.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import io.github.mateuussilvapb.hexagonal.adapters.out.InsertCustomerAdapter;
import io.github.mateuussilvapb.hexagonal.application.core.useCase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
    }
}
