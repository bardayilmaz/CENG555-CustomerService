package com.fishauction.customerservice.kafka.application;

import com.fishauction.customerservice.customer.domain.model.entity.Customer;
import com.fishauction.customerservice.customer.domain.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class CustomerListener {

    private final CustomerRepository customerRepository;

    @KafkaListener(topics = "userRegistered", groupId = "${spring.kafka.group-id}")
    public void listen(Customer record) {
        // Handle the consumed record
        System.out.println("Received record: " + record);

        System.out.println("Received record: " + record);
        System.out.println("Received record id: " + record.getId());
        System.out.println("Received record created date: " + record.getCreatedDate());
        System.out.println("Received record modified date: " + record.getModifiedDate());
        System.out.println("Received record name: " + record.getName());
        System.out.println("Received record surname: " + record.getSurname());
        System.out.println("Received record email: " + record.getEmail());
        System.out.println("Received record premium: " + record.isPremium());
        customerRepository.save(record);
    }
}
