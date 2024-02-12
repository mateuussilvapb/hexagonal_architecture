package io.github.mateuussilvapb.hexagonal.config;

import io.github.mateuussilvapb.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import io.github.mateuussilvapb.hexagonal.application.core.useCase.DeleteCustomerByIdUseCase;
import io.github.mateuussilvapb.hexagonal.application.core.useCase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase, DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
