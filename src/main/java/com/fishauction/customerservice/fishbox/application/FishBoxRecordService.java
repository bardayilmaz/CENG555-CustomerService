package com.fishauction.customerservice.fishbox.application;

import com.fishauction.customerservice.common.application.EmailService;
import com.fishauction.customerservice.customer.domain.model.entity.Customer;
import com.fishauction.customerservice.customer.domain.repository.CustomerRepository;
import com.fishauction.customerservice.fishbox.domain.model.entity.FishBoxRecord;
import com.fishauction.customerservice.fishbox.domain.model.http.response.FishBoxRecordResponse;
import com.fishauction.customerservice.fishbox.domain.model.mapper.FishBoxRecordMapper;
import com.fishauction.customerservice.fishbox.domain.repository.DailyFishBoxCanBePublishedRepository;
import com.fishauction.customerservice.fishbox.domain.repository.FishBoxRecordRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class FishBoxRecordService {

    private final FishBoxRecordRepository fishBoxRecordRepository;
    private final CustomerRepository customerRepository;
    private final EmailService emailService;
    private final DailyFishBoxCanBePublishedRepository dailyFishBoxCanBePublishedRepository;

    public void sendDailyMailToPremiumCustomers() {
        List<Customer> premiumCustomers = customerRepository.findAllByPremium(true);
        List<FishBoxRecord> dailyRecords = fishBoxRecordRepository.findAllByAuctionDate(LocalDate.now());
        String mailText = "Dear customer, here are the fish box records for today:\n";
        for (FishBoxRecord fishBoxRecord : dailyRecords) {
            mailText = mailText.concat(fishBoxRecord.getBoxId().concat(" - ").concat(fishBoxRecord.getFisherName()).concat(" - ")
                    .concat(String.valueOf(fishBoxRecord.getWeight())).concat("\n"));
        }
        for (Customer customer : premiumCustomers) {
            emailService.sendEmail(customer.getEmail(), "Daily Fish Box Records", mailText);
        }
    }

    public List<FishBoxRecordResponse> getDailyReportAfterAuction() {
        if (!dailyFishBoxCanBePublishedRepository.existsByDate(LocalDate.now())) {
            throw new RuntimeException("Daily fish box records are not published yet");
        }
        List<FishBoxRecord> dailyRecords = fishBoxRecordRepository.findAllByAuctionDate(LocalDate.now());
        return dailyRecords.stream().map(FishBoxRecordMapper::toResponse).toList();
    }
}
