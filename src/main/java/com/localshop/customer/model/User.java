package com.localshop.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    private Integer id;
    private String email;
    private String password;

    @JsonProperty("mobile_no")
    private String mobileNo;
    private Address address;
}
