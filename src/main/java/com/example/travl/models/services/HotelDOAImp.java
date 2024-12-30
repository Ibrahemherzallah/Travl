package com.example.travl.models.services;

import com.example.travl.models.Hotel;
import com.example.travl.models.interfaces.HotelDOA;
import com.example.travl.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HotelDOAImp implements HotelDOA {

    HibernateUtil hibernateUtil;
    SessionFactory sessionFactory;
    public HotelDOAImp() {
        hibernateUtil = HibernateUtil.getInstance();
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    @Override
    public void insert(Hotel hotel) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(hotel);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Hotel hotel) {

    }

    @Override
    public void delete(Hotel hotel) {

    }

    @Override
    public List<Hotel> getAll() {
        return List.of();
    }

    @Override
    public Hotel findAdmin(int id) {
        return null;
    }
}
