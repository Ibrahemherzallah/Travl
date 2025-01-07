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
    Session session;
    public CustomerDOAImp() {
        hibernateUtil = HibernateUtil.getInstance();
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }
    @Override
    public void insert(Customer customer) {
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        sessionFactory.openSession().close();
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

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
