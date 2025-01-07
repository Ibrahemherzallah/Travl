package com.example.travl.models.services;

import com.example.travl.models.Hotel;
import com.example.travl.models.interfaces.HotelDOA;
import com.example.travl.models.util.DatabaseUtil;
import com.example.travl.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDOAImp implements HotelDOA {

    HibernateUtil hibernateUtil;
    SessionFactory sessionFactory;
    public HotelDOAImp() {
        hibernateUtil = com.example.travl.util.HibernateUtil.getInstance();
        sessionFactory = com.example.travl.util.HibernateUtil.getSessionFactory();
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
        SessionFactory sessionFactory = com.example.travl.util.HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Hotel> hotels = new ArrayList<>(); // Initialize to an empty list
        try {
            // Native SQL query
            String sql = "SELECT * FROM hotel";
            hotels = session.createNativeQuery(sql, Hotel.class).getResultList();

            // Debugging output
            for (Hotel hotel : hotels) {
                System.out.println("Hotel Retrieved: " + hotel.getHotelName() + " -> " + hotel.getLocation());
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        } finally {
            session.close(); // Ensure the session is always closed
        }

        return hotels; // Will return an empty list if the query fails
    }


    @Override
    public Hotel findAdmin(int id) {
        return null;
    }

    public List<Object[]> getPromotedHotels() {
        SessionFactory sessionFactory = com.example.travl.util.HibernateUtil.getInstance().getSessionFactory();
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
    public Hotel getHotelById(int id) {
        String query = "SELECT * FROM hotels WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getInt("id"));
                hotel.setHotelName(resultSet.getString("name"));
                hotel.setLocation(resultSet.getString("location"));
                hotel.setCreated_at(resultSet.getDate("created_at"));
                hotel.setPricePerNight(resultSet.getDouble("price_per_night"));
               // hotel.setImg(resultSet.getBytes("image"));
                return hotel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}