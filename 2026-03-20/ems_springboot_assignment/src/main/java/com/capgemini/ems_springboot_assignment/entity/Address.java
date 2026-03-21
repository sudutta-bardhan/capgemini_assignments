package com.capgemini.ems_springboot_assignment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private String city;
    private String state;
    private String country;

    @Pattern(regexp = "\\d{6}", message = "Pincode must be 6 digits")
    private String pincode;
}