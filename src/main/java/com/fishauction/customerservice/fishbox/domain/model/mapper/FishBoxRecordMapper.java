package com.fishauction.customerservice.fishbox.domain.model.mapper;

import com.fishauction.customerservice.fishbox.domain.model.entity.FishBoxRecord;
import com.fishauction.customerservice.fishbox.domain.model.http.response.FishBoxRecordResponse;

public class FishBoxRecordMapper {

    public static FishBoxRecordResponse toResponse(FishBoxRecord fishBoxRecord) {
        return FishBoxRecordResponse.builder()
                .id(fishBoxRecord.getId())
                .createdDate(fishBoxRecord.getCreatedDate())
                .modifiedDate(fishBoxRecord.getModifiedDate())
                .boxId(fishBoxRecord.getBoxId())
                .fisherName(fishBoxRecord.getFisherName())
                .weight(fishBoxRecord.getWeight())
                .auctionDate(fishBoxRecord.getAuctionDate())
                .build();
    }
}
