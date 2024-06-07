package com.fishauction.customerservice.kafka.application;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fishauction.customerservice.kafka.model.AuctionEndedBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuctionEndedBodyDeserializer extends JsonDeserializer<AuctionEndedBody> {



    @Override
    public AuctionEndedBody deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Long auctionId = node.get("auction_id").asLong();
        LocalDateTime auctionEndTime = LocalDateTime.parse(node.get("auction_end_time").asText(), DateTimeFormatter.ISO_DATE_TIME);
        Integer totalTrays = node.get("total_trays").asInt();
        Integer totalSoldTrays = node.get("total_sold_trays").asInt();
        Integer totalUnsoldTrays = node.get("total_unsold_trays").asInt();
        Double totalRevenue = node.get("total_revenue").asDouble();

        return new AuctionEndedBody(auctionId, auctionEndTime, totalTrays, totalSoldTrays, totalUnsoldTrays, totalRevenue);
    }
}
