package com.fishauction.customerservice.kafka.application;

import com.fishauction.customerservice.fishbox.domain.model.entity.FishBoxRecord;
import com.fishauction.customerservice.fishbox.domain.repository.FishBoxRecordRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class FishingRecordListener {

    private final FishBoxRecordRepository fishBoxRecordRepository;

    @KafkaListener(topics = "test-topic", groupId = "${spring.kafka.group-id}")
    public void listen(List<FishBoxRecord> record) {
        // Handle the consumed record
        System.out.println("Received record: " + record);
        for (FishBoxRecord fishBoxRecord : record) {
            System.out.println("Received record: " + fishBoxRecord);
            System.out.println("Received record id: " + fishBoxRecord.getId());
            System.out.println("Received record created date: " + fishBoxRecord.getCreatedDate());
            System.out.println("Received record modified date: " + fishBoxRecord.getModifiedDate());
            System.out.println("Received record box id: " + fishBoxRecord.getBoxId());
            System.out.println("Received record fisher name: " + fishBoxRecord.getFisherName());
            System.out.println("Received record weight: " + fishBoxRecord.getWeight());
            System.out.println("Received record weight: " + fishBoxRecord.getAuctionDate());
            fishBoxRecordRepository.save(fishBoxRecord);
        }
    }
}
