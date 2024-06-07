package com.fishauction.customerservice.fishbox.domain.model.entity;

import com.fishauction.customerservice.common.domain.entity.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "fish_box_record")
public class DailyFishBoxCanBePublished extends Auditable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;
}
