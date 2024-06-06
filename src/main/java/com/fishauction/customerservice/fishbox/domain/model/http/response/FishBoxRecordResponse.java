package com.fishauction.customerservice.fishbox.domain.model.http.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Data
@Builder
public class FishBoxRecordResponse {

    private Long id;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;
    private String boxId;
    private String fisherName;
    private float weight;
    private LocalDate auctionDate;
}
