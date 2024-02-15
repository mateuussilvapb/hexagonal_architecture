package io.github.mateuussilvapb.hexagonal.adapters.out;

import io.github.mateuussilvapb.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        this.kafkaTemplate.send("tp-cpf-validation", cpf);
    }
}
