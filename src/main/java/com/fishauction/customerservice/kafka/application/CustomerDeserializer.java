package com.fishauction.customerservice.kafka.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fishauction.customerservice.customer.domain.model.entity.Customer;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;


public class CustomerDeserializer implements Deserializer<Customer> {

    private ObjectMapper objectMapper;

    public CustomerDeserializer () {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Register JavaTimeModule
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No special configuration needed
    }

    @Override
    public Customer deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize JSON message", e);
        }
    }

    @Override
    public void close() {
        // No special cleanup needed
    }
}
