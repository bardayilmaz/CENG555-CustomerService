package com.fishauction.customerservice.kafka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class CustomerResponse implements Serializable {

    public CustomerResponse() {
    }

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("premium")
    private boolean premium;
}
