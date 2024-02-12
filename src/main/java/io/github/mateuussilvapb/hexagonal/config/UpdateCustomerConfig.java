package io.github.mateuussilvapb.hexagonal.config;

import io.github.mateuussilvapb.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import io.github.mateuussilvapb.hexagonal.adapters.out.UpdateCustomerAdapter;
import io.github.mateuussilvapb.hexagonal.application.core.useCase.FindCustomerByIdUseCase;
import io.github.mateuussilvapb.hexagonal.application.core.useCase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase, FindAddressByZipCodeAdapter findAddressByZipCodeAdapter, UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
