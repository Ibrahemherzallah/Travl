package com.example.travl.models.services;

import com.example.travl.models.Admin;
import com.example.travl.models.Agent;
import com.example.travl.models.interfaces.AgentDOA;
import com.example.travl.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AgentDOAImp implements AgentDOA {



    @Override
    public void insert(Agent agent) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(agent);
        session.getTransaction().commit();
        sessionFactory.openSession().close();
    }

    @Override
    public void update(Agent agent) {

    }

    @Override
    public void delete(Agent agent) {

    }

    @Override
    public List<Agent> getAll() {
        return List.of();
    }

    @Override
    public Agent findAdmin(int id) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.get(Agent.class, id);
    }
}
