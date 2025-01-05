package com.example.travl.models.services;

import com.example.travl.models.Customer;
import com.example.travl.models.Flight;
import com.example.travl.models.interfaces.CustomerDOA;
import com.example.travl.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CustomerDOAImp implements CustomerDOA {

    HibernateUtil hibernateUtil;
    SessionFactory sessionFactory;
    public CustomerDOAImp() {
        hibernateUtil = HibernateUtil.getInstance();
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    @Override
    public void insert(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }

    @Override
    public Customer findAdmin(int id) {
        return null;
    }
}
