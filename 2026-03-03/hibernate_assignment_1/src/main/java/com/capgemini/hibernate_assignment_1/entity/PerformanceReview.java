package com.capgemini.hibernate_assignment_1.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="performance_review")
public class PerformanceReview
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="review_id")
    private int id;

    @Column(name="employee_code")
    private String employeeCode;

    @Column(name="rating")
    private int rating;

    @Column(name="review_date")
    private LocalDate reviewDate;

    @Column(name="comments")
    private String comments;

    public PerformanceReview()
    {
        super();
    }

    public PerformanceReview(String employeeCode, int rating, LocalDate reviewDate, String comments)
    {
        this.employeeCode = employeeCode;
        this.rating = rating;
        this.reviewDate = reviewDate;
        this.comments = comments;
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

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public LocalDate getReviewDate()
    {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate)
    {
        this.reviewDate = reviewDate;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

	@Override
	public int hashCode()
	{
		return Objects.hash(comments, employeeCode, id, rating, reviewDate);
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
		PerformanceReview other = (PerformanceReview) obj;
		return Objects.equals(comments, other.comments) && Objects.equals(employeeCode, other.employeeCode)
				&& id == other.id && rating == other.rating && Objects.equals(reviewDate, other.reviewDate);
	}

	@Override
	public String toString()
	{
		return "PerformanceReview [id=" + id + ", employeeCode=" + employeeCode + ", rating=" + rating + ", reviewDate="
				+ reviewDate + ", comments=" + comments + "]";
	}  
}