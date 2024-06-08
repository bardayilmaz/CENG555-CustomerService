package com.fishauction.customerservice.kafka.application;

import com.fishauction.customerservice.customer.domain.model.entity.Customer;
import com.fishauction.customerservice.customer.domain.repository.CustomerRepository;
import com.fishauction.customerservice.kafka.model.CustomerResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class CustomerListener {

    private final CustomerRepository customerRepository;

    @KafkaListener(topics = "${kafka.customer-topic}", groupId = "${spring.kafka.group-id}", containerFactory = "kafkaListenerContainerFactoryCustomer")
    public void listen(CustomerResponse record) {
        // Handle the consumed record
        System.out.println("Received record: " + record);

        System.out.println("Received record: " + record);
        System.out.println("Received record id: " + record.getId());
        System.out.println("Received record name: " + record.getName());
        System.out.println("Received record surname: " + record.getSurname());
        System.out.println("Received record email: " + record.getEmail());
        System.out.println("Received record premium: " + record.isPremium());

        Customer customer = new Customer();
        customer.setId(record.getId());
        customer.setName(record.getName());
        customer.setSurname(record.getSurname());
        customer.setEmail(record.getEmail());
        customer.setPremium(record.isPremium());
        customerRepository.save(customer);
    }
}
