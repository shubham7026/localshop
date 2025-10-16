package com.localshop.customer.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address {
    private int id;

    private String city;
    private int pinCode;
    private String state;
}
