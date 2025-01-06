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
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Hotel> hotels = null;
        try {
            // Native SQL query
            String sql = "SELECT * FROM hotel";
            hotels = session.createNativeQuery(sql, Hotel.class).getResultList();

            // Debugging output
            for (Hotel hotel : hotels) {
                System.out.println("Hotel Retrieved: " + hotel.getHotelName() + " -> " + hotel.getLocation());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return hotels;
    }


    @Override
    public Hotel findAdmin(int id) {
        return null;
    }

    public List<Object[]> getPromotedHotels() {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Object[]> promotedHotels = null;
        try {
            // SQL query to fetch promoted hotels
            String sql = "SELECT hotel_name, location, image FROM hotel WHERE promotion = true";
            promotedHotels = session.createNativeQuery(sql).getResultList();

            // Debugging output
            for (Object[] row : promotedHotels) {
                String hotelName = (String) row[0];
                String location = (String) row[1];
                byte[] imageBytes = (byte[]) row[2];

                System.out.println("Promoted Hotel: " + hotelName + ", Location: " + location);
                System.out.println("Image Bytes Length: " + (imageBytes != null ? imageBytes.length : "No Image"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return promotedHotels;
    }

}