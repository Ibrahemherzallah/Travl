package com.example.travl.models.services;

import com.example.travl.models.Flight;
import com.example.travl.models.interfaces.FlightDOA;
import com.example.travl.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FlightDOAImp implements FlightDOA {


    @Override
    public void insert(Flight flight) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(flight);
        session.getTransaction().commit();
        sessionFactory.openSession().close();
    }

    @Override
    public void update(Flight flight) {

    }

    @Override
    public void delete(Flight flight) {

    }

    @Override
    public List<Flight> getAll() {
        return List.of();
    }

    @Override
    public Flight findAdmin(int id) {
        return null;
    }
}
