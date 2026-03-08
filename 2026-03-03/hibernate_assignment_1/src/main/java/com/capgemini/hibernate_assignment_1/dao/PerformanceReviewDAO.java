package com.capgemini.hibernate_assignment_1.dao;

import com.capgemini.hibernate_assignment_1.entity.PerformanceReview;

import javax.persistence.*;
import java.util.List;

public class PerformanceReviewDAO
{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void insertReview(PerformanceReview review)
    {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(review);
        transaction.commit();
    }

    public void updateReview(int id, int rating, String comments)
    {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        PerformanceReview review = entityManager.find(PerformanceReview.class, id);

        review.setRating(rating);
        review.setComments(comments);

        entityManager.merge(review);

        transaction.commit();
    }

    public void deleteReview(int id)
    {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        PerformanceReview review = entityManager.find(PerformanceReview.class, id);

        entityManager.remove(review);

        transaction.commit();
    }

    public List<PerformanceReview> getReviewsByEmployee(String code)
    {
        TypedQuery<PerformanceReview> query =
                entityManager.createQuery(
                        "SELECT r FROM PerformanceReview r WHERE r.employeeCode = :code",
                        PerformanceReview.class);

        query.setParameter("code", code);

        List<PerformanceReview> reviews =
                query.getResultList();

        return reviews;
    }
}