package com.fishauction.customerservice.kafka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AuctionEndedBody {

    @JsonProperty("auction_id")
    private Long auctionId;

    @JsonProperty("auction_end_time")
    private LocalDateTime auctionEndTime;

    @JsonProperty("total_trays")
    private Integer totalTrays;

    @JsonProperty("total_sold_trays")
    private Integer totalSoldTrays;

    @JsonProperty("total_unsold_trays")
    private Integer totalUnsoldTrays;

    @JsonProperty("total_revenue")
    private Double totalRevenue;
}
