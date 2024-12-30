package com.example.travl.models.services;

import com.example.travl.models.User;
import com.example.travl.models.interfaces.UserDOA;
import com.example.travl.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDOAImp implements UserDOA {

    @Override
    public void insert(User User) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(User);
        session.getTransaction().commit();
        sessionFactory.openSession().close();
    }

    @Override
    public void update(User User) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(User);
        session.getTransaction().commit();
        sessionFactory.openSession().close();
    }

    @Override
    public void delete(User User) {

    }

    @Override
    public List<User> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createQuery("select u from User u").list();
    }

    @Override
    public User findUser(int id) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.get(User.class, id);
    }
}
