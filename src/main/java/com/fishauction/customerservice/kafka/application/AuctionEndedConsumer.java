package com.fishauction.customerservice.kafka.application;

import com.fishauction.customerservice.fishbox.domain.model.entity.DailyFishBoxCanBePublished;
import com.fishauction.customerservice.fishbox.domain.repository.DailyFishBoxCanBePublishedRepository;
import com.fishauction.customerservice.kafka.model.AuctionEndedBody;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
@Transactional
public class AuctionEndedConsumer {

    private final DailyFishBoxCanBePublishedRepository dailyFishBoxCanBePublishedRepository;

    @KafkaListener(topics = "auction-ended", groupId = "group_id", containerFactory = "kafkaListenerContainerFactoryAuctionEnded")
    public void consumeAuctionEnded(AuctionEndedBody auctionEndedBody) {
        DailyFishBoxCanBePublished dailyFishBoxCanBePublished = new DailyFishBoxCanBePublished();
        dailyFishBoxCanBePublished.setDate(LocalDate.now());
        dailyFishBoxCanBePublishedRepository.save(dailyFishBoxCanBePublished);
        System.out.println("Consumed message: " + auctionEndedBody);
        System.out.println("AUCTIONENDED");
        System.out.println("AUCTIONENDED");
    }
}
