package io.github.mateuussilvapb.hexagonal.adapters.in.consumer;

import io.github.mateuussilvapb.hexagonal.adapters.in.consumer.message.CustomerMessage;
import io.github.mateuussilvapb.hexagonal.application.core.domain.Customer;
import io.github.mateuussilvapb.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class ReceiveValidatedCpfConsumer {
    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "dias")
    public void receive(CustomerMessage customerMessage) {
        Customer customer = this.customerMessageMapper.toCustomer(customerMessage);
        this.updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
