package com.example.travl.models.services;

import com.example.travl.models.BookingService;
import com.example.travl.models.interfaces.BookingServiceDOA;
import com.example.travl.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
public class BookingServiceDOAImp implements BookingServiceDOA {
    private final SessionFactory sessionFactory;

    public BookingServiceDOAImp() {
        // Initialize the sessionFactory using HibernateUtil
        sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory == null) {
            throw new IllegalStateException("SessionFactory initialization failed. Please check Hibernate configuration.");
        }
    }

    @Override
    public BookingService findBooking(String bookingID) {
        try (Session session = sessionFactory.openSession()) {
            // HQL query to fetch BookingService along with related Flight and Hotel data based on BookingID
            Query<BookingService> query = session.createQuery(
                    "SELECT bs FROM BookingService bs " +
                            "LEFT JOIN FETCH bs.flight f " +
                            "LEFT JOIN FETCH bs.hotel h " +
                            "WHERE bs.id = :bookingID",
                    BookingService.class
            );
            query.setParameter("bookingID", Long.valueOf(bookingID));
            return query.uniqueResult(); // This will return a BookingService object containing both Flight and Hotel data if available
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
