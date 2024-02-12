package io.github.mateuussilvapb.hexagonal.adapters.out;

import io.github.mateuussilvapb.hexagonal.adapters.out.repository.CustomerRepository;
import io.github.mateuussilvapb.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id){
        customerRepository.deleteById(id);
    }

}
