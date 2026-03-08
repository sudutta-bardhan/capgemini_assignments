package com.capgemini.hibernate_assignment_1.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="employee")
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="employee_id")
	private int id;
	
	@Column(name="employee_code", unique=true)
	private String employeeCode;
	
	@Column(name="employee_name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="department")
	private String department;

	@Column(name="joining_date")
	private LocalDate joiningDate;
	
	@Column(name="active")
	private boolean active=true;

	public Employee()
	{
		super();
	}

	public Employee (String employeeCode, String name, String email, String designation, String department, LocalDate joiningDate, boolean active)
	{
		this.employeeCode = employeeCode;
		this.name = name;
		this.email = email;
		this.designation = designation;
		this.department = department;
		this.joiningDate = joiningDate;
		this.active = active;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getEmployeeCode()
	{
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode)
	{
		this.employeeCode = employeeCode;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	public LocalDate getJoiningDate()
	{
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate)
	{
		this.joiningDate = joiningDate;
	}

	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(active, department, designation, email, employeeCode, id, joiningDate, name);
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
		Employee other = (Employee) obj;
		return active == other.active && Objects.equals(department, other.department)
				&& Objects.equals(designation, other.designation) && Objects.equals(email, other.email)
				&& Objects.equals(employeeCode, other.employeeCode) && id == other.id
				&& Objects.equals(joiningDate, other.joiningDate) && Objects.equals(name, other.name);
	}

	@Override
	public String toString()
	{
		return "Employee [id=" + id + ", employeeCode=" + employeeCode + ", name=" + name + ", email=" + email
				+ ", designation=" + designation + ", department=" + department + ", joiningDate=" + joiningDate
				+ ", active=" + active + "]";
	}
}