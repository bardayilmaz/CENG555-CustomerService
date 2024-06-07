package com.fishauction.customerservice.fishbox.domain.repository;

import com.fishauction.customerservice.fishbox.domain.model.entity.DailyFishBoxCanBePublished;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface DailyFishBoxCanBePublishedRepository extends JpaRepository<DailyFishBoxCanBePublished, Long> {

    boolean existsByDate(LocalDate now);
}
