package com.example.travl.models.services;

import com.example.travl.models.BookingService;
import com.example.travl.models.Customer;
import com.example.travl.models.interfaces.BookingServiceDOA;
import com.example.travl.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookingServiceDOAImp implements BookingServiceDOA {
    HibernateUtil hibernateUtil;
    SessionFactory sessionFactory;
    public BookingServiceDOAImp() {
        hibernateUtil = HibernateUtil.getInstance();
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(BookingService bookingService) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(bookingService);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(BookingService bookingService) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(bookingService);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(BookingService bookingService) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(bookingService);
        session.getTransaction().commit();
        session.close();
    }
    public List<BookingService> getAllBookings() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM BookingService bs LEFT JOIN FETCH bs.flight LEFT JOIN FETCH bs.hotel", BookingService.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Customer> getAll() {
        return List.of();
    }
}