package io.github.mateuussilvapb.hexagonal.adapters.in.controller;

import io.github.mateuussilvapb.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import io.github.mateuussilvapb.hexagonal.adapters.in.controller.request.CustomerRequest;
import io.github.mateuussilvapb.hexagonal.adapters.in.controller.response.CustomerResponse;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;
import io.github.mateuussilvapb.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import io.github.mateuussilvapb.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = this.customerMapper.toCustomer(customerRequest);
        this.insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        Customer customer = this.findCustomerByIdInputPort.find(id);
        CustomerResponse customerResponse = this.customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }
}
