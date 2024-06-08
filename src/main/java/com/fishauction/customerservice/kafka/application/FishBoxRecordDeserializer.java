package com.fishauction.customerservice.kafka.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fishauction.customerservice.fishbox.domain.model.entity.FishBoxRecord;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.List;
import java.util.Map;

public class FishBoxRecordDeserializer implements Deserializer<List<FishBoxRecord>> {

    private ObjectMapper objectMapper;

    public FishBoxRecordDeserializer () {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Register JavaTimeModule
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No special configuration needed
    }

    @Override
    public List<FishBoxRecord> deserialize(String topic, byte[] data) {
        try {
            System.out.println("Deserializing data: " + data);
            System.out.println("topic " + topic);
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
