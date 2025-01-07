package com.example.travl.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class AdminDashController {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/newDB";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "";
    @FXML
    private ImageView homeIconAD;
    @FXML
    private ImageView flightIconAD;
    @FXML
    private ImageView hotelIconAD;
    @FXML
    private ImageView addAgentAD;
    @FXML
    private ImageView addFlightAD;
    @FXML
    private ImageView addHotelAD;
    @FXML
    private ImageView logoutIcon;

    @FXML
    private Label userCountLabel;

    @FXML
    private Label bookingCountLabel;

    @FXML
    private Label hotelCountLabel;

    @FXML
    private Label flightCountLabel;

    @FXML
    private Label availableFlight;

    @FXML
    private Label availableHotel;

    @FXML
    private Label hotelNameLabel;


    @FXML
    private Label flightName;

    @FXML
    private Label lastAgentBooking;
    @FXML
    private Label lastAgentBookingOfHotel;
    @FXML
    private Label lastAgentBookingOfFlight;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private Circle image3;

    private final Map<Integer, ImageView> imageViews = new HashMap<>();


    @FXML
    protected void navigateHomeAD() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/admin-dash.fxml"));

            Stage stage = (Stage) homeIconAD.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    @FXML
    protected void navigateFlightAD() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/flight-listing-admin.fxml"));

            Stage stage = (Stage) flightIconAD.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    @FXML
    protected void navigateHotelAD() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/hotel-listing-admin.fxml"));

            Stage stage = (Stage) hotelIconAD.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    @FXML
    protected void navigateAddAgentAD() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/agent-list.fxml"));

            Stage stage = (Stage) addAgentAD.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    @FXML
    protected void navigateAddFlightAD() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/add-flight.fxml"));

            Stage stage = (Stage) addFlightAD.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    @FXML
    protected void navigateAddHotelAD() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/add-hotel.fxml"));

            Stage stage = (Stage) addFlightAD.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    @FXML
    protected void navigateLogout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/log-in.fxml"));

            Stage stage = (Stage) logoutIcon.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }


    }

    private void loadUserCount() {
        String query = "select COUNT(*) AS agent_count from user where role_id = 2";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                int userCount = resultSet.getInt("agent_count");
                userCountLabel.setText(String.valueOf(userCount));
            } else {
                userCountLabel.setText("0");
            }
        } catch (Exception e) {
            System.err.println("Error fetching user count: " + e.getMessage());
            e.printStackTrace();
            userCountLabel.setText("Error");
        }
    }

    private void loadBookingCount() {
        String query = "SELECT COUNT(*) AS booking_count FROM booking_services";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                int bookingCount = resultSet.getInt("booking_count");
                bookingCountLabel.setText(String.valueOf(bookingCount));
            } else {
                bookingCountLabel.setText("0");
            }
        } catch (Exception e) {
            System.err.println("Error fetching user count: " + e.getMessage());
            e.printStackTrace();
            userCountLabel.setText("Error");
        }

    }

    private void loadHotelCount() {
        String query = "SELECT COUNT(*) AS hotel_count FROM hotel";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {


            if (resultSet.next()) {
                int hotelCount = resultSet.getInt("hotel_count");
                hotelCountLabel.setText(String.valueOf(hotelCount));

            } else {
                hotelCountLabel.setText("0");
            }
        } catch (Exception e) {
            System.err.println("Error fetching user count: " + e.getMessage());
            e.printStackTrace();
            hotelCountLabel.setText("Error");
        }
    }

    private void loadFlightCount() {
        String query = "SELECT COUNT(*) AS flight_count FROM flight";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int flightCount = resultSet.getInt("flight_count");
                flightCountLabel.setText(String.valueOf(flightCount));

            } else {
                flightCountLabel.setText("0");
            }
        } catch (Exception e) {
            System.err.println("Error fetching user count: " + e.getMessage());
            e.printStackTrace();
            flightCountLabel.setText("Error");
        }
    }

    private void loadAvailableFlight() {
        String query = "SELECT COUNT(available_flight ) AS available_flight FROM flight WHERE available_flight = TRUE";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int flightCount = resultSet.getInt("available_flight");
                availableFlight.setText(String.valueOf(flightCount));

            } else {
                availableFlight.setText("0");
            }
        } catch (Exception e) {
            System.err.println("Error fetching user count: " + e.getMessage());
            e.printStackTrace();
            availableFlight.setText("Error");
        }


    }

    private void loadAvailableHotel() {
        String query = "SELECT COUNT(available_rooms) AS available_rooms FROM hotel WHERE available_rooms > 0  ";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int flightCount = resultSet.getInt("available_rooms");
                availableHotel.setText(String.valueOf(flightCount));

            } else {
                availableHotel.setText("0");
            }
        } catch (Exception e) {
            System.err.println("Error fetching user count: " + e.getMessage());
            e.printStackTrace();
            availableHotel.setText("Error");
        }
    }

    private void loadHotelName() {
        String query = "SELECT hotel.hotel_name " +
                "FROM booking_services " +
                "INNER JOIN hotel ON booking_services.hotel_id = hotel.id " +
                "ORDER BY booking_services.created_at DESC " +
                "LIMIT 1;";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                String hotelName = resultSet.getString("hotel_name");
                hotelNameLabel.setText(hotelName != null ? hotelName : "Unknown");
            } else {
                hotelNameLabel.setText("No Hotels Found");
            }
        } catch (Exception e) {
            System.err.println("Error fetching hotel name: " + e.getMessage());
            e.printStackTrace();
            hotelNameLabel.setText("Error");
        }
    }

    private void loadFlightName() {
        String query = "SELECT flight.flight_name " +
                "FROM booking_services " +
                "INNER JOIN flight ON booking_services.flight_id = flight.id " +
                "ORDER BY booking_services.created_at DESC " +
                "LIMIT 1;";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                String flight_Name = resultSet.getString("flight_name");
                flightName.setText(flight_Name != null ? flight_Name : "Unknown");
            } else {
                flightName.setText("No Hotels Found");
            }
        } catch (Exception e) {
            System.err.println("Error fetching hotel name: " + e.getMessage());
            e.printStackTrace();
            flightName.setText("Error");
        }
    }

    private void loadLastAgentLogedIN(Label agentName) {
        String query = "SELECT CONCAT(user.first_name,' ', user.last_name )AS agent_name FROM booking_services " +
                "INNER JOIN user ON booking_services.user_id = user.id " +
                "ORDER BY booking_services.created_at DESC ";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                String agent_name = resultSet.getString("agent_name");
                agentName.setText(agent_name != null ? agent_name : "Unknown");
            } else {
                agentName.setText("No Hotels Found");
            }

        } catch (Exception e) {
            System.err.println("Error fetching hotel name: " + e.getMessage());
            e.printStackTrace();
            agentName.setText("Error");

        }
    }

    private void loadLastAgentBooking(Label agentName) {
        String query = "SELECT CONCAT(user.first_name,' ', user.last_name )AS agent_name FROM booking_services \n" +
                "                INNER JOIN user ON booking_services.user_id = user.id \n" +
                "                ORDER BY booking_services.booking_date DESC";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                String agent_name = resultSet.getString("agent_name");
                agentName.setText(agent_name != null ? agent_name : "Unknown");
            } else {
                agentName.setText("No Hotels Found");
            }

        } catch (Exception e) {
            System.err.println("Error fetching hotel name: " + e.getMessage());
            e.printStackTrace();
            agentName.setText("Error");

        }
    }


    private void loadHotelImage() {
        String query = "SELECT image_id, image FROM hotel WHERE image_id = 1";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("image_id");
                byte[] imageBytes = resultSet.getBytes("image");

                try {

                    Image image = (imageBytes != null) ? new Image(new ByteArrayInputStream(imageBytes)) : null;
                    if (image != null) {
                        imageViews.get(id).setImage(image);
                    } else {
                        System.err.println("No matching UI element for hotel ID: " + id);
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Error loading image for hotel ID " + id + ": " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error loading hotel data: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void initialize() {
        loadUserCount();
        loadBookingCount();
        loadHotelCount();
        loadFlightCount();
        loadAvailableFlight();
        loadAvailableHotel();
        loadHotelName();
        loadFlightName();
        loadLastAgentBooking(lastAgentBookingOfHotel);
        loadLastAgentBooking(lastAgentBookingOfFlight);
        loadLastAgentLogedIN(lastAgentBooking);
        loadHotelImage();


    }

}