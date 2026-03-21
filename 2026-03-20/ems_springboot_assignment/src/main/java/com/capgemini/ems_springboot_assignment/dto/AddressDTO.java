package com.capgemini.ems_springboot_assignment.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressDTO
{
    private String street;
    private String city;
    private String state;
    private String country;

    @Pattern(regexp = "\\d{6}", message = "Pincode must be 6 digits")
    private String pincode;
}