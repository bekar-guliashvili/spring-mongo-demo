package com.example.springmongodemo.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "City is required")
    private String city;
    @NotNull(message = "zipcode is required")
    private Integer zipCode;

}
