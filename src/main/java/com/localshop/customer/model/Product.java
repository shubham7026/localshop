package com.localshop.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Product  {
    private int id;
    private BigDecimal price;
    private String productOrigin;
}
