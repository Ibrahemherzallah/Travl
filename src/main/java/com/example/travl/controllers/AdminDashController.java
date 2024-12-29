package com.example.travl.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class AdminDashController {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/tayara_Db";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "123456789";
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
        String query = "SELECT COUNT(*) AS user_count FROM user";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                int userCount = resultSet.getInt("user_count");
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
        String query = "SELECT COUNT(*) AS booking_count FROM booking";
        try (Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                int bookingCount = resultSet.getInt("booking_count");
                bookingCountLabel.setText(String.valueOf(bookingCount));
            } else {
                bookingCountLabel.setText("0");
            }
        }catch (Exception e) {
            System.err.println("Error fetching user count: " + e.getMessage());
            e.printStackTrace();
            userCountLabel.setText("Error");
        }

    }

    private void loadHotelCount() {
        String query = "SELECT COUNT(*) AS hotel_count FROM hotel";
        try(Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()){


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

        try( Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next()) {
                int flightCount = resultSet.getInt("flight_count");
                flightCountLabel.setText(String.valueOf(flightCount));

            }else {
                flightCountLabel.setText("0");
            }
        }catch (Exception e) {
            System.err.println("Error fetching user count: " + e.getMessage());
            e.printStackTrace();
            flightCountLabel.setText("Error");
        }
    }
    public void initialize() {
        loadUserCount();
        loadBookingCount();
        loadHotelCount();
        loadFlightCount();
    }

}


