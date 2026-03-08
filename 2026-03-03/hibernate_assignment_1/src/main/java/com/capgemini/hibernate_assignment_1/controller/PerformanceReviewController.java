package com.capgemini.hibernate_assignment_1.controller;

import com.capgemini.hibernate_assignment_1.dao.PerformanceReviewDAO;
import com.capgemini.hibernate_assignment_1.entity.PerformanceReview;

import java.time.LocalDate;
import java.util.List;

public class PerformanceReviewController
{
    public static void main(String[] args)
    {
        PerformanceReviewDAO dao = new PerformanceReviewDAO();

        PerformanceReview r1 = new PerformanceReview("EMP101",5,LocalDate.of(2025,3,1),"Excellent performance");
        PerformanceReview r2 = new PerformanceReview("EMP102",4,LocalDate.of(2025,3,2),"Very good");
        PerformanceReview r3 = new PerformanceReview("EMP103",3,LocalDate.of(2025,3,3),"Average performance");
        PerformanceReview r4 = new PerformanceReview("EMP101",4,LocalDate.of(2025,6,1),"Improved productivity");

        dao.insertReview(r1);
        dao.insertReview(r2);
        dao.insertReview(r3);
        dao.insertReview(r4);

        System.out.println("Reviews inserted");

        List<PerformanceReview> reviews = dao.getReviewsByEmployee("EMP101");

        for(PerformanceReview r : reviews)
        {
            System.out.println(r);
        }

        dao.updateReview(1,5,"Outstanding contribution");
        System.out.println("Review updated");

        dao.deleteReview(3);
        System.out.println("Review deleted");
    }
}