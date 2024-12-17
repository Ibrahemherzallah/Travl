package com.example.travl.models.services;

import com.example.travl.models.Admin;
import com.example.travl.models.interfaces.AdminDOA;
import com.example.travl.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AdminDOAImp implements AdminDOA {

    @Override
    public void insert(Admin admin) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
        sessionFactory.openSession().close();
    }

    @Override
    public void update(Admin admin) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
        sessionFactory.openSession().close();
    }

    @Override
    public void delete(Admin admin) {

    }

    @Override
    public List<Admin> getAll() {
        return List.of();
    }

    @Override
    public Admin findAdmin(int id) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.get(Admin.class, id);
    }
}
