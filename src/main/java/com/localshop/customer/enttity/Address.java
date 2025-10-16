package com.localshop.customer.enttity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
public class Address {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;
    private int pinCode;
    private String state;
}
