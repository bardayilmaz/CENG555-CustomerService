package com.fishauction.customerservice.fishbox.application;

import com.fishauction.customerservice.fishbox.domain.model.entity.FishBoxRecord;
import com.fishauction.customerservice.fishbox.domain.model.http.response.FishBoxRecordResponse;
import com.fishauction.customerservice.fishbox.domain.model.mapper.FishBoxRecordMapper;
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

    // TODO send daily mails to premium customers
    public void sendDailyMailToPremiumCustomers() {
        // TODO get all premium customers
        List<FishBoxRecord> dailyRecords = fishBoxRecordRepository.findAllByAuctionDate(LocalDate.now());
        // TODO send email to premium customers
    }

    public List<FishBoxRecordResponse> getDailyReportAfterAuction() {
        // TODO auction ended check required
        List<FishBoxRecord> dailyRecords = fishBoxRecordRepository.findAllByAuctionDate(LocalDate.now());
        return dailyRecords.stream().map(FishBoxRecordMapper::toResponse).toList();
    }

}
