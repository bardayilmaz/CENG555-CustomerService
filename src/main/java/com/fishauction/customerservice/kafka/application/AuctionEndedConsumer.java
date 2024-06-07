package com.fishauction.customerservice.kafka.application;

import com.fishauction.customerservice.fishbox.domain.model.entity.DailyFishBoxCanBePublished;
import com.fishauction.customerservice.fishbox.domain.repository.DailyFishBoxCanBePublishedRepository;
import com.fishauction.customerservice.kafka.model.AuctionEndedBody;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class AuctionEndedConsumer {

    private final DailyFishBoxCanBePublishedRepository dailyFishBoxCanBePublishedRepository;

    @KafkaListener(topics = "auction_ended", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void consumeAuctionEnded(AuctionEndedBody auctionEndedBody) {
        DailyFishBoxCanBePublished dailyFishBoxCanBePublished = new DailyFishBoxCanBePublished();
        dailyFishBoxCanBePublished.setDate(LocalDate.now());
        dailyFishBoxCanBePublishedRepository.save(dailyFishBoxCanBePublished);
        System.out.println("Consumed message: " + auctionEndedBody);
    }
}
