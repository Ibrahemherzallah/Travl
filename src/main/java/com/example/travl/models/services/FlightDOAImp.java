package com.example.travl.models.services;

import com.example.travl.models.Flight;
import com.example.travl.models.interfaces.FlightDOA;
import com.example.travl.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class FlightDOAImp implements FlightDOA {

    public List<Object[]> getPromotedFlights() {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Object[]> promotedFlights = null;
        try {
            // SQL query to fetch promoted flights
            String sql = "SELECT flight_name, airline, image FROM flight WHERE promotion = true";
            promotedFlights = session.createNativeQuery(sql).getResultList();

            // Debugging output
            for (Object[] row : promotedFlights) {
                String flightName = (String) row[0];
                String airlineName = (String) row[1];
                byte[] imageBytes = (byte[]) row[2];

                System.out.println("Promoted Flight: " + flightName + ", Airline: " + airlineName);
                System.out.println("Image Bytes Length: " + (imageBytes != null ? imageBytes.length : "No Image"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return promotedFlights;
    }

    @Override
    public void insert(Flight flight) {
        SessionFactory sessionFactory = com.example.travl.util.HibernateUtil.getInstance().getSessionFactory();
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
        SessionFactory sessionFactory = com.example.travl.util.HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Flight> flights = new ArrayList<>(); // Always initialize to an empty list
        try {
            // Native SQL query
            String sql = "SELECT * FROM flight";
            flights = session.createNativeQuery(sql, Flight.class).getResultList();

            // Debugging output
            for (Flight flight : flights) {
                System.out.println("Flight Retrieved: " + flight.getAirline() + " -> " + flight.getDestination());
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        } finally {
            session.close();
        }

        return flights; // Will return an empty list if the query fails
    }

    @Override
    public Flight findAdmin(int id) {
        return null;
    }
}