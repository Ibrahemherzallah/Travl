package com.example.travl.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AgentDashController  {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/travlbr";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "root";

    @FXML private ImageView homeIcon;
    @FXML private ImageView flightIcon;
    @FXML private ImageView hotelIcon;
    @FXML private ImageView historyIcon;
    @FXML private ImageView logoutIcon;
    @FXML private Label hotelDetailBtn;
    @FXML private Label viewBookingListingBtn;
    @FXML private Label bookCountLabel;
    @FXML private Label  customerCountLabel;
    @FXML private Label hotelCountLabel;
    @FXML private Label flightCountLabel;
    @FXML private Label availableFlightCountLabel;
    @FXML private Label availableHotelCountLabel;
    @FXML private Label hotelNameLabel;
    @FXML private Label hotelUserNameLabel;
    @FXML private Label timeBookedHotel ;
    @FXML private Label FlightNameLabel;
    @FXML private Label FlightUserNameLabel;
    @FXML private Label timeBookedFlight;
    public void navigateHome(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/agent-dash.fxml"));

            Stage stage = (Stage) homeIcon.getScene().getWindow();
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
    protected void navigateFlight(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/flight-listing.fxml"));

            Stage stage = (Stage) flightIcon.getScene().getWindow();
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
    protected void navigateHotel(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/hotel-listing.fxml"));

            Stage stage = (Stage) hotelIcon.getScene().getWindow();
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
    protected void navigateHistory(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/all-history-booking.fxml"));

            Stage stage = (Stage) historyIcon.getScene().getWindow();
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
    protected void navigateLogout(){
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
    @FXML
    protected void navigateHotelBook(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/hotel-book-details.fxml"));

            Stage stage = (Stage) hotelDetailBtn.getScene().getWindow();
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
    protected void navigateBookingListing(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/all-history-booking.fxml"));

            Stage stage = (Stage) viewBookingListingBtn.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    private void availableFlight() {
        String query = "SELECT COUNT(f.id) AS available_flight " +
                "FROM flight f " +
                "LEFT JOIN booking_services bs ON f.id = bs.flight_id " +
                "WHERE bs.id IS NULL OR bs.booking_type IS NULL";


        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int flightCount = resultSet.getInt("available_flight");
                availableFlightCountLabel.setText(String.valueOf(flightCount));
            } else {
                availableFlightCountLabel.setText("0");
            }
        } catch (Exception e) {
            System.err.println("404 error db not access or no DATA");
            e.printStackTrace();
            availableFlightCountLabel.setText("No data");
        }

    }


    private void availableHotel() {
        String query = "SELECT COUNT(h.id) AS available_hotels " +
                "FROM hotel h " +
                "LEFT JOIN booking_services bs ON h.id = bs.hotel_id " +
                "WHERE bs.id IS NULL OR bs.booking_type IS NULL";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int flightCount = resultSet.getInt("available_hotels");
                availableHotelCountLabel.setText(String.valueOf(flightCount));
            } else {
                availableHotelCountLabel.setText("0");
            }
        } catch (Exception e) {
            System.err.println("404 error db not access or no DATA");
            e.printStackTrace();
            availableHotelCountLabel.setText("No data");
        }

    }

    private void customerCount() {
        String query = "select COUNT(*) AS customer_count from user where role_id = 3";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                int userCount = resultSet.getInt("customer_count");
                customerCountLabel.setText(String.valueOf(userCount));
            } else {
                customerCountLabel.setText("0");
            }
        } catch (Exception e) {
            System.err.println("404 error db not access or no DATA");
            e.printStackTrace();
            customerCountLabel.setText("No data");
        }
    }

    private void countBooking() {
        String query = "SELECT COUNT(*) AS booking_count FROM booking_services";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                int bookingCount = resultSet.getInt("booking_count");
                bookCountLabel.setText(String.valueOf(bookingCount));
            } else {
                bookCountLabel.setText("0");
            }
        } catch (Exception e) {
            System.err.println("404 error db not access or no DATA");
            e.printStackTrace();
            bookCountLabel.setText("No data");
        }
    }
        private void countHotel()  {
            String query = "SELECT COUNT(*) AS hotel_count FROM hotel";

            // Using try-with-resources to ensure proper resource management
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Check if the result set has a value
                if (resultSet.next()) {
                    int hotelCount = resultSet.getInt("hotel_count");
                    hotelCountLabel.setText(String.valueOf(hotelCount));
                } else {
                    hotelCountLabel.setText("0");  // If no rows are found, display 0
                }
                }
            catch (Exception e) {
                    System.err.println("404 error db not access or no DATA");
                    e.printStackTrace();
                hotelCountLabel.setText("No data");
                }

            }


    private void countFlight() {
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
            System.err.println("404 error db not access or no DATA");
            e.printStackTrace();
            flightCountLabel.setText("No data");
        }

    }

    private void getLatestHotelBooking() {
        String query = "SELECT h.hotel_name, u.first_name AS customer_name, bs.created_at AS booking_time " +
                "FROM booking_services bs " +
                "JOIN hotel h ON bs.hotel_id = h.id " +
                "JOIN user u ON bs.user_id = u.id " +
                "WHERE bs.booking_type = 'Hotel Booking' " +
                "ORDER BY bs.created_at DESC " +
                "LIMIT 1";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                String hotelName = resultSet.getString("hotel_name");
                String customerName = resultSet.getString("customer_name");
                Timestamp bookingTime = resultSet.getTimestamp("booking_time");

                // Format the timestamp
                String formattedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(bookingTime);

                // Update the UI components
                hotelNameLabel.setText(hotelName);
                hotelUserNameLabel.setText(customerName);
                timeBookedHotel.setText(formattedTime);

            } else {
                // If no booking is found, set default messages
                hotelNameLabel.setText("No bookings found");
                hotelUserNameLabel.setText("");
                timeBookedHotel.setText("");
            }

        } catch (SQLException e) {
            System.err.println("Database access error or no data available.");
            e.printStackTrace();
            hotelNameLabel.setText("Error fetching booking data");
            hotelUserNameLabel.setText("");
            timeBookedHotel.setText("");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
            hotelNameLabel.setText("Unexpected error");
            hotelUserNameLabel.setText("");
            timeBookedHotel.setText("");
        }
    }

    private void getLatestFlightBooking() {
        String query = "SELECT f.flight_name, u.first_name AS customer_name, bs.created_at AS booking_time " +
                "FROM booking_services bs " +
                "JOIN flight f ON bs.flight_id = f.id " +
                "JOIN user u ON bs.user_id = u.id " +
                "WHERE bs.booking_type = 'Flight Booking' " +
                "ORDER BY bs.created_at DESC " +
                "LIMIT 1";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                String flightName = resultSet.getString("flight_name");
                String customerName = resultSet.getString("customer_name");
                Timestamp bookingTime = resultSet.getTimestamp("booking_time");

                String formattedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(bookingTime);

                FlightNameLabel.setText(flightName); // Repurpose this label to display flight name
                FlightUserNameLabel.setText(customerName);
                timeBookedFlight.setText(formattedTime);

            } else {
                FlightNameLabel.setText("No flight bookings found");
                FlightUserNameLabel.setText("");
                timeBookedFlight.setText("");
            }

        } catch (SQLException e) {
            System.err.println("Database access error or no data available.");
            e.printStackTrace();
            FlightNameLabel.setText("Error fetching booking data");
            FlightUserNameLabel.setText("");
            timeBookedFlight.setText("");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
            FlightNameLabel.setText("Unexpected error");
            FlightUserNameLabel.setText("");
            timeBookedFlight.setText("");
        }
    }

    public void initialize() {
            availableFlight();
            availableHotel();
            customerCount();
            countBooking();
            countHotel();
            countFlight();
            getLatestHotelBooking();
            getLatestFlightBooking();
    }

}

