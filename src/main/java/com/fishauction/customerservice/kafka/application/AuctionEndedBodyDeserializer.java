package com.fishauction.customerservice.kafka.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fishauction.customerservice.kafka.model.AuctionEndedBody;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class AuctionEndedBodyDeserializer implements Deserializer<AuctionEndedBody> {


    private ObjectMapper objectMapper;

    public AuctionEndedBodyDeserializer () {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Register JavaTimeModule
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No special configuration needed
    }

    @Override
    public AuctionEndedBody deserialize(String topic, byte[] data) {
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
