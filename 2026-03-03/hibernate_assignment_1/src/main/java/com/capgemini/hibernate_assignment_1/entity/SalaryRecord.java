package com.capgemini.hibernate_assignment_1.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="salary_record")
public class SalaryRecord
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="salary_id")
    private int id;

    @Column(name="employee_code")
    private String employeeCode;

    @Column(name="base_salary")
    private double baseSalary;

    @Column(name="bonus")
    private double bonus;

    @Column(name="tax")
    private double tax;

    @Column(name="net_salary")
    private double netSalary;

    @Column(name="salary_month")
    private String salaryMonth;

    public SalaryRecord()
    {
        super();
    }

    public SalaryRecord(String employeeCode, double baseSalary, double bonus, double tax, String salaryMonth)
    {
        this.employeeCode = employeeCode;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.tax = tax;

        this.netSalary = baseSalary + bonus - tax;

        this.salaryMonth = salaryMonth;
    }

    public int getId()
    {
        return id;
    }

    public String getEmployeeCode()
    {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode)
    {
        this.employeeCode = employeeCode;
    }

    public double getBaseSalary()
    {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary)
    {
        this.baseSalary = baseSalary;
    }

    public double getBonus()
    {
        return bonus;
    }

    public void setBonus(double bonus)
    {
        this.bonus = bonus;
    }

    public double getTax()
    {
        return tax;
    }

    public void setTax(double tax)
    {
        this.tax = tax;
    }

    public double getNetSalary()
    {
        return netSalary;
    }

    public void setNetSalary(double netSalary)
    {
        this.netSalary = netSalary;
    }

    public String getSalaryMonth()
    {
        return salaryMonth;
    }

    public void setSalaryMonth(String salaryMonth)
    {
        this.salaryMonth = salaryMonth;
    }

	@Override
	public int hashCode()
	{
		return Objects.hash(baseSalary, bonus, employeeCode, id, netSalary, salaryMonth, tax);
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
		SalaryRecord other = (SalaryRecord) obj;
		return Double.doubleToLongBits(baseSalary) == Double.doubleToLongBits(other.baseSalary)
				&& Double.doubleToLongBits(bonus) == Double.doubleToLongBits(other.bonus)
				&& Objects.equals(employeeCode, other.employeeCode) && id == other.id
				&& Double.doubleToLongBits(netSalary) == Double.doubleToLongBits(other.netSalary)
				&& Objects.equals(salaryMonth, other.salaryMonth)
				&& Double.doubleToLongBits(tax) == Double.doubleToLongBits(other.tax);
	}

	@Override
	public String toString()
	{
		return "SalaryRecord [id=" + id + ", employeeCode=" + employeeCode + ", baseSalary=" + baseSalary + ", bonus="
				+ bonus + ", tax=" + tax + ", netSalary=" + netSalary + ", salaryMonth=" + salaryMonth + "]";
	}
}