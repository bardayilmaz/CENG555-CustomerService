package com.fishauction.customerservice.fishbox.domain.model.entity;

import com.fishauction.customerservice.common.domain.entity.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "fish_box_record")
public class FishBoxRecord extends Auditable implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "box_id")
    private String boxId;

    @Column(name = "fisher_name")
    private String fisherName;

    @Column(name = "weight")
    private float weight;

    @Column(name = "auction_date")
    private LocalDate auctionDate;
}
