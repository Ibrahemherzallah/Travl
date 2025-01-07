package com.example.travl.models.services;

import com.example.travl.models.Flight;
import com.example.travl.models.Hotel;
import com.example.travl.models.interfaces.FlightDOA;
import com.example.travl.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FlightDOAImp implements FlightDOA {

    public List<Object[]> getPromotedFlights() {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Object[]> promotedFlights = null;
        try {
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


    HibernateUtil hibernateUtil;
    SessionFactory sessionFactory;
    Session session;

    public FlightDOAImp() {
        hibernateUtil = HibernateUtil.getInstance();
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }
    @Override
    public void insert(Flight flight) {

        session.beginTransaction();
        session.save(flight);
        session.getTransaction().commit();
        sessionFactory.openSession().close();
    }

    @Override
    public void update(Flight flight) {
        session.beginTransaction();
        session.update(flight);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Flight flight) {

    }

    @Override
    public List<Flight> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Flight> flights = null;
        try {

            String sql = "SELECT * FROM flight";
            flights = session.createNativeQuery(sql, Flight.class).getResultList();


            for (Flight flight : flights) {
                System.out.println("Flight Retrieved: " + flight.getAirline() + " -> " + flight.getDestination());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return flights;
    }

    @Override
    public Flight findAdmin(int id) {
        return null;
    }

    public Flight getFlightlByID(int ID) {
        System.out.println("the function entereeeeeeeeeeeeed"  + ID);
        return session.get(Flight.class,ID);
    }

    public List<Flight> getFlightByHour(int num) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = null;
        List<Flight> flights = null;
        try {
            if(num == 5){
                sql = "SELECT * FROM flight WHERE duration BETWEEN 0 AND 5";
            } else if (num == 10) {
                sql = "SELECT * FROM flight WHERE duration BETWEEN 5 AND 10";
            } else if (num == 15) {
                 sql = "SELECT * FROM flight WHERE duration > 10";
            }
            flights = session.createNativeQuery(sql, Flight.class).getResultList();


            for (Flight flight : flights) {
                System.out.println("Flight Retrieved: " + flight.getAirline() + " -> " + flight.getDestination());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return flights;
    }

    public List<Flight> getFlightByAirline(String airline) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = null;
        List<Flight> flights = null;
        try {
            if(airline == "Emirates Airlines"){
                sql = "SELECT * FROM flight WHERE airline = 'Emirates Airlines'";
            } else if (airline == "Qatar Airlines") {
                sql = "SELECT * FROM flight WHERE airline = 'Qatar Airlines'";
            } else if (airline == "Turkish Airlines") {
                sql = "SELECT * FROM flight WHERE airline = 'Turkish Airlines'";
            } else if (airline == "Etihad Airlines") {
                sql = "SELECT * FROM flight WHERE airline = 'Etihad Airlines'";
            }
            flights = session.createNativeQuery(sql, Flight.class).getResultList();


            for (Flight flight : flights) {
                System.out.println("Flight Retrieved: " + flight.getAirline() + " -> " + flight.getDestination());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return flights;
    }

    public List<Flight> getSearchedFlight(String takeOff, String land, String dateIn, String dateOut) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = null;
        List<Flight> flights = null;
        try {
            sql = "SELECT * FROM flight " +
                    "WHERE des_from = :takeOff " +
                    "AND destination = :land " +
                    "AND departure_date = :dateIn " +
                    "AND arrival_date = :dateOut";
            flights = session.createNativeQuery(sql, Flight.class).setParameter("takeOff", takeOff)
                    .setParameter("land", land)
                    .setParameter("dateIn", dateIn)
                    .setParameter("dateOut", dateOut)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return flights;
    }
}

