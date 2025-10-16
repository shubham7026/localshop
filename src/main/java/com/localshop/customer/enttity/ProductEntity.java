package com.localshop.customer.enttity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    private int id;
    private BigDecimal price;

    @Column(name = "product_origin")
    private String productOrigin;
}
