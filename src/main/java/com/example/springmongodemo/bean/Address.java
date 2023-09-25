package com.example.springmongodemo.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String address;
    private String city;
    private int zipCode;
}
