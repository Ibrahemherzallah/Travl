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
    Session session;

    public HotelDOAImp() {
        hibernateUtil = HibernateUtil.getInstance();
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }
    @Override
    public void insert(Hotel hotel) {
        session.beginTransaction();
        session.save(hotel);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Hotel hotel) {
        session.beginTransaction();
        session.update(hotel);
        session.getTransaction().commit();
        session.close();
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

            String sql = "SELECT * FROM hotel";
            hotels = session.createNativeQuery(sql, Hotel.class).getResultList();


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

    @Override
    public Hotel getHotelByID(int id) {
        return null;
    }

    public List<Object[]> getPromotedHotels() {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Object[]> promotedHotels = null;
        try {

            String sql = "SELECT hotel_name, location, image FROM hotel WHERE promotion = true";
            promotedHotels = session.createNativeQuery(sql).getResultList();


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

    public List<Hotel> getHotelByStar(int numOfStar){
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = null;
        List<Hotel> hotels = null;
        try {
            if(numOfStar == 5){
                sql = "SELECT * FROM hotel WHERE num_of_star = 5";
            }else if (numOfStar == 4){
                sql = "SELECT * FROM hotel WHERE num_of_star = 4";
            }else if (numOfStar == 3){
                sql = "SELECT * FROM hotel WHERE num_of_star = 3";
            }else if (numOfStar == 2){
                sql = "SELECT * FROM hotel WHERE num_of_star = 2";
            }else if (numOfStar == 1){
                sql = "SELECT * FROM hotel WHERE num_of_star = 1";
            }
            hotels = session.createNativeQuery(sql, Hotel.class).getResultList();


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


}








