package com.fishauction.customerservice.fishbox.domain.repository;

import com.fishauction.customerservice.fishbox.domain.model.entity.FishBoxRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FishBoxRecordRepository extends JpaRepository<FishBoxRecord, Long> {

    List<FishBoxRecord> findAllByAuctionDate(LocalDate now);
}
