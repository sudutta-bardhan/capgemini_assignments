package com.capgemini.hibernate_assignment_2.entity;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id", nullable = false, unique = true)
	private int addressId;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "pincode")
	private int pincode;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public Address()
	{
		super();
	}

	public Address(int addressId, String street, int pincode, String state, String city, String country, Employee employee)
	{
		super();
		this.addressId = addressId;
		this.street = street;
		this.pincode = pincode;
		this.state = state;
		this.city = city;
		this.country = country;
		this.employee = employee;
	}

	public int getAddressId()
	{
		return addressId;
	}

	public void setAddressId(int addressId)
	{
		this.addressId = addressId;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public int getPincode()
	{
		return pincode;
	}

	public void setPincode(int pincode)
	{
		this.pincode = pincode;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(addressId, city, country, pincode, state, street);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return addressId == other.addressId && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && pincode == other.pincode
				&& Objects.equals(state, other.state) && Objects.equals(street, other.street);
	}

	@Override
	public String toString()
	{
		return "Address [addressId=" + addressId + ", street=" + street + ", pincode=" + pincode + ", state=" + state
				+ ", city=" + city + ", country=" + country + "]";
	}
}