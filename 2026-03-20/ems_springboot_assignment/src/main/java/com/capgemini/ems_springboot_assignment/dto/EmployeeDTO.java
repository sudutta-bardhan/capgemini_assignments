package com.capgemini.ems_springboot_assignment.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Email(message = "Invalid email")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
    private String phone;

    private String gender;
    private String designation;

    @Positive(message = "Salary must be greater than 0")
    private double salary;

    private LocalDate dateOfJoining;

    private AddressDTO address;
}