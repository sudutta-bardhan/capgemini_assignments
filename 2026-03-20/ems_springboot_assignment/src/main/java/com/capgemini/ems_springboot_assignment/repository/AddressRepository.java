package com.capgemini.ems_springboot_assignment.repository;

import com.capgemini.ems_springboot_assignment.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer>
{

}