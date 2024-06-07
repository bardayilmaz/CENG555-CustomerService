package com.fishauction.customerservice.customer.domain.model.entity;

import com.fishauction.customerservice.common.domain.entity.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer extends Auditable  {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "surname")
    private String surname;

    @Column(name = "premium")
    private boolean premium;

    @Column(name = "password")
    private String password;
}
