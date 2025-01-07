package com.example.travl.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javafx.scene.image.Image;

public class BookingController {

    private static final String DB_PASSWORD = "";
    @FXML
    public ImageView imageOfPromo_p2;
    public ImageView imageOfPromo_p1;
    @FXML
    private Label price_h1 ;
    @FXML
    private Label price_h2 ;
    @FXML
    private Label price_h3 ;
    @FXML
    private Label price_h4 ;

    @FXML
    private ImageView image_h1, image_h2, image_h3, image_h4;

    @FXML
    private Label nameOfHotel_h1, nameOfHotel_h2, nameOfHotel_h3, nameOfHotel_h4;

    @FXML
    private Label location_h1, location_h2, location_h3, location_h4;

    @FXML
    private VBox promotionList;

    @FXML
    private ImageView image_p1, image_p2;

    @FXML
    private Label nameOfPromo_p1, nameOfPromo_p2;

    @FXML
    private Label descriptionOfPromo_p1,  descriptionOfPromo_p2;
    @FXML private Button viewFlightBookBtn;
    @FXML private Button viewHotelBookBtn;
    @FXML private Button viewHotelDetailsBtn1;
    @FXML private Button viewHotelDetailsBtn2;
    @FXML private Button backTOFromHotel;
    @FXML private Button backFlightListingButton;
    @FXML private Button backToHistoryListing;
    @FXML private Button bookingBtn;
    @FXML private ImageView homeIcon;
    @FXML private ImageView logoutIcon;
    @FXML private ImageView flightIcon;
    @FXML private ImageView hotelIcon;
    @FXML private ImageView historyIcon;
    @FXML private Button selectFlightBtn;
    @FXML private Button viewHotelDetailsBtn;
    @FXML private Button backHotelListingButton;
    @FXML private Button viewFlightDetailsBtn1;
    @FXML private Button viewFlightDetailsBtn2;

    @FXML private Label customerNameF;
    @FXML private Label customerPhoneF;
    @FXML private Label coustomerEmailF;
    @FXML private Label customerAddF;
    @FXML private Label checkinF;
    @FXML private Label chekoutF;
    @FXML private Label createAtF;
    @FXML private Label NkidsF;
    @FXML private Label paymentMF;
    @FXML private Label statusF;
    @FXML private Button editButton;
    @FXML private TextField customerNameTextField, customerPhoneTextField, coustomerEmailTextField, customerAddTextField, checkinTextField, chekoutTextField, createAtTextField, NkidsTextField, paymentMTextField, statusTextField;
    private boolean isEditing = false;

    @FXML private Label flightRoute;
    @FXML private Label flightTime;
    @FXML private Label airlineName;
    @FXML private Label flightNumber;
    @FXML private Label passengerName;
    @FXML private Label flightStatus;
    @FXML private Label bookingDate;
    @FXML private Label phoneNumber;
    @FXML private Label checkinTime;
    @FXML private Label checkoutTime;
    @FXML private Label price;
    @FXML private Label address;
    @FXML private Label email;
    @FXML private Label numAdults;
    @FXML private Label numKids;
    @FXML private Label paymentMethod;
    ///
    @FXML private TextField flightRouteF;
    @FXML private TextField flightTimeF;
    @FXML private TextField airlineNameF;
    @FXML private TextField flightNumberF;
    @FXML private TextField passengerNameF;
    @FXML private TextField flightStatusF;
    @FXML private TextField bookingDateF;
    @FXML private TextField phoneNumberF;
    @FXML private TextField checkinTimeF;
    @FXML private TextField checkoutTimeF;
    @FXML private TextField priceF;
    @FXML private TextField addressF;
    @FXML private TextField emailF;
    @FXML private TextField numAdultsF;
    @FXML private TextField numKidsF;
    @FXML private TextField paymentMethodF;
    @FXML
    private ImageView imagePromo1 ;
    @FXML private ImageView imagePromo2 ;
    @FXML private Label namePromo1;
    @FXML private Label namePromo2;
    @FXML
    private Label airlineName_a1;
    @FXML
    private Label ticketNo_a1;
    @FXML
    private Label takeoffTime_a1;
    @FXML
    private Label takeoffPlace_a1;
    @FXML
    private Label arrivalTime_a1;
    @FXML
    private Label destination_a1;
    @FXML
    private Label timeToLand_a1;
    @FXML
    private Label Stops_a1;

    @FXML
    private Label airlineName_a2;
    @FXML
    private Label ticketNo_a2;
    @FXML
    private Label takeoffTime_a2;
    @FXML
    private Label takeoffPlace_a2;
    @FXML
    private Label arrivalTime_a2;
    @FXML
    private Label destination_a2;
    @FXML
    private Label timeToLand_a2;
    @FXML
    private Label Stops_a2;

    @FXML
    private Label promoPlace_p1;
    @FXML
    private ImageView promoImage_p1;
    @FXML
    private Label promoPlace_p2;
    @FXML
    private ChoiceBox<String> myChoiceBox;

    @FXML
    private ImageView promoImage_p2;
    private Map<Integer, Label> nameLabels = new HashMap<>();
    private Map<Integer, Label> locationLabels = new HashMap<>();
    private Map<Integer, Label> priceLabels = new HashMap<>();
    private Map<Integer, ImageView> imageViews = new HashMap<>();
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/newDB";
    private final String DB_USERNAME = "root";
    private String[] priceSorted = {"High to Low " , "Low to High"};

    @FXML
    public void initialize() {
        nameLabels.put(1, nameOfHotel_h1);
        nameLabels.put(2, nameOfHotel_h2);
        nameLabels.put(3, nameOfHotel_h3);
        nameLabels.put(4, nameOfHotel_h4);
        locationLabels.put(1, location_h1);
        locationLabels.put(2, location_h2);
        locationLabels.put(3, location_h3);
        locationLabels.put(4, location_h4);
        priceLabels.put(1, price_h1);
        priceLabels.put(2, price_h2);
        priceLabels.put(3, price_h3);
        priceLabels.put(4, price_h4);
        imageViews.put(1, image_h1);
        imageViews.put(2, image_h2);
        imageViews.put(3, image_h3);
        imageViews.put(4, image_h4);
        loadHotelData();
        loadHotelPromotionData();
        loadFlightData();
       loadFlightPromotionData();
//        loadChoiceBox();
    }
    private void loadFlightData() {
        String query = "SELECT * FROM flight";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String flightName = resultSet.getString("flight_name");
                String airline = resultSet.getString("airline");
                int ticketPrice = resultSet.getInt("ticket_price");
                String departureDate = resultSet.getString("departure_date");
                String arrivalDate = resultSet.getString("arrival_date");
                String stops = resultSet.getString("stops");
                String destination = resultSet.getString("destination");
                String duration = resultSet.getString("duration");

                switch (id) {
                    case "1":
                        airlineName_a1.setText(airline);
                        ticketNo_a1.setText(flightName + " - $" + ticketPrice);
                        takeoffTime_a1.setText(departureDate);
                        takeoffPlace_a1.setText("");
                        arrivalTime_a1.setText(arrivalDate);
                        destination_a1.setText(destination);
                        timeToLand_a1.setText(duration);
                        Stops_a1.setText(stops);
                        break;
                    case "2":
                        airlineName_a2.setText(airline);
                        ticketNo_a2.setText(flightName + " - $" + ticketPrice);
                        takeoffTime_a2.setText(departureDate);
                        takeoffPlace_a2.setText("");
                        arrivalTime_a2.setText(arrivalDate);
                        destination_a2.setText(destination);
                        timeToLand_a2.setText(duration);
                        Stops_a2.setText(stops);
                        break;
                    default:
                        System.err.println("No matching UI element for flight ID: " + id);
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error loading flight data: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private void loadFlightPromotionData() {
        String query = "SELECT flight_name, image FROM flight WHERE promotion = true";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            int promoIndex = 1;
            while (resultSet.next() && promoIndex <= 2) {
                String flightName = resultSet.getString("flight_name");
                byte[] imageBytes = resultSet.getBytes("image");


                System.out.println("Flight Name: " + flightName);
                System.out.println("Image Bytes Length: " + (imageBytes != null ? imageBytes.length : "No Image"));

                try {

                    Image promoImage = (imageBytes != null) ? new Image(new ByteArrayInputStream(imageBytes)) : null;

                    switch (promoIndex) {
                        case 1:
                            namePromo1.setText(flightName);
                            if (promoImage != null) {
                                imagePromo1.setImage(promoImage);
                            } else {
                                imagePromo1.setImage(new Image(""));
                            }
                            break;

                        case 2:
                            namePromo2.setText(flightName);
                            if (promoImage != null) {
                                imagePromo2.setImage(promoImage);
                            } else {
                                imagePromo2.setImage(new Image(""));
                            }
                            break;

                        default:
                            System.err.println("No matching promotion UI element for index: " + promoIndex);
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Error loading promotion image for index " + promoIndex + ": " + e.getMessage());
                }

                promoIndex++;
            }

        } catch (Exception e) {
            System.err.println("Error loading flight promotion data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadHotelData() {
        String query = "SELECT * FROM hotel";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("hotel_name");
                String location = resultSet.getString("location");
                double pricePerNight = resultSet.getDouble("price_per_night");
                byte[] imageBytes = resultSet.getBytes("image");

                try {

                    Image image = (imageBytes != null) ? new Image(new ByteArrayInputStream(imageBytes)) : null;

                    if (nameLabels.containsKey(id)) {
                        nameLabels.get(id).setText(name);
                        locationLabels.get(id).setText(location);
                        priceLabels.get(id).setText("$" + pricePerNight);
                        if (image != null) {
                            imageViews.get(id).setImage(image);
                        }
                    } else {
                        System.err.println("No matching  hotel ID: " + id);
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Error loading image ID " + id + ": " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error loading hotel data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadHotelPromotionData() {
        String query = "SELECT hotel_name, location, image FROM hotel WHERE promotion = true";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            int promoIndex = 1;
            while (resultSet.next() && promoIndex <= 2) {
                String hotelName = resultSet.getString("hotel_name");
                String location = resultSet.getString("location");
                byte[] imageBytes = resultSet.getBytes("image");


                System.out.println("Hotel Name: " + hotelName);
                System.out.println("Location: " + location);
                System.out.println("Image Bytes: " + (imageBytes != null ? imageBytes.length : "No Image"));

                try {

                    Image promoImage = (imageBytes != null) ? new Image(new ByteArrayInputStream(imageBytes)) : null;

                    switch (promoIndex) {
                        case 1:
                            nameOfPromo_p1.setText(hotelName);
                            if (promoImage != null) {
                                imageOfPromo_p1.setImage(promoImage);
                            }

                            break;

                        case 2:
                            nameOfPromo_p2.setText(hotelName);
                            if (promoImage != null) {
                                imageOfPromo_p2.setImage(promoImage);
                            }


                            break;

                        default:
                            System.err.println("No matching promotion UI element : " + promoIndex);
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Error loading promotion image for index " + promoIndex + ": " + e.getMessage());
                }

                promoIndex++;
            }

        } catch (Exception e) {
            System.err.println("Error loading  data: " + e.getMessage());
            e.printStackTrace();
        }
    }







    @FXML
    public void handleEditButtonClick() {
        if (isEditing) {
            customerNameF.setText(customerNameTextField.getText());
            customerPhoneF.setText(customerPhoneTextField.getText());
            coustomerEmailF.setText(coustomerEmailTextField.getText());
            customerAddF.setText(customerAddTextField.getText());
            checkinF.setText(checkinTextField.getText());
            chekoutF.setText(chekoutTextField.getText());
            createAtF.setText(createAtTextField.getText());
            NkidsF.setText(NkidsTextField.getText());
            paymentMF.setText(paymentMTextField.getText());
            statusF.setText(statusTextField.getText());

            customerNameTextField.setVisible(false);
            customerPhoneTextField.setVisible(false);
            coustomerEmailTextField.setVisible(false);
            customerAddTextField.setVisible(false);
            checkinTextField.setVisible(false);
            chekoutTextField.setVisible(false);
            createAtTextField.setVisible(false);
            NkidsTextField.setVisible(false);
            paymentMTextField.setVisible(false);
            statusTextField.setVisible(false);

            customerNameF.setVisible(true);
            customerPhoneF.setVisible(true);
            coustomerEmailF.setVisible(true);
            customerAddF.setVisible(true);
            checkinF.setVisible(true);
            chekoutF.setVisible(true);
            createAtF.setVisible(true);
            NkidsF.setVisible(true);
            paymentMF.setVisible(true);
            statusF.setVisible(true);

            editButton.setText("Edit");
        } else {
            customerNameTextField.setText(customerNameF.getText());
            customerPhoneTextField.setText(customerPhoneF.getText());
            coustomerEmailTextField.setText(coustomerEmailF.getText());
            customerAddTextField.setText(customerAddF.getText());
            checkinTextField.setText(checkinF.getText());
            chekoutTextField.setText(chekoutF.getText());
            createAtTextField.setText(createAtF.getText());
            NkidsTextField.setText(NkidsF.getText());
            paymentMTextField.setText(paymentMF.getText());
            statusTextField.setText(statusF.getText());

            customerNameTextField.setVisible(true);
            customerPhoneTextField.setVisible(true);
            coustomerEmailTextField.setVisible(true);
            customerAddTextField.setVisible(true);
            checkinTextField.setVisible(true);
            chekoutTextField.setVisible(true);
            createAtTextField.setVisible(true);
            NkidsTextField.setVisible(true);
            paymentMTextField.setVisible(true);
            statusTextField.setVisible(true);

            customerNameF.setVisible(false);
            customerPhoneF.setVisible(false);
            coustomerEmailF.setVisible(false);
            customerAddF.setVisible(false);
            checkinF.setVisible(false);
            chekoutF.setVisible(false);
            createAtF.setVisible(false);
            NkidsF.setVisible(false);
            paymentMF.setVisible(false);
            statusF.setVisible(false);

            editButton.setText("Save");
        }

        isEditing = !isEditing;
    }
    @FXML
    public void handleEditButtonClickFly() {
        if (isEditing) {
            flightRoute.setText(flightRouteF.getText());
            flightTime.setText(flightTimeF.getText());
            airlineName.setText(airlineNameF.getText());
            flightNumber.setText(flightNumberF.getText());
            passengerName.setText(passengerNameF.getText());
            flightStatus.setText(flightStatusF.getText());
            bookingDate.setText(bookingDateF.getText());
            phoneNumber.setText(phoneNumberF.getText());
            checkinTime.setText(checkinTimeF.getText());
            checkoutTime.setText(checkoutTimeF.getText());
            price.setText(priceF.getText());
            address.setText(addressF.getText());
            email.setText(emailF.getText());
            numAdults.setText(numAdultsF.getText());
            numKids.setText(numKidsF.getText());
            paymentMethod.setText(paymentMethodF.getText());

            toggleVisibility(false);

            editButton.setText("Edit");
        } else {
            flightRouteF.setText(flightRoute.getText());
            flightTimeF.setText(flightTime.getText());
            airlineNameF.setText(airlineName.getText());
            flightNumberF.setText(flightNumber.getText());
            passengerNameF.setText(passengerName.getText());
            flightStatusF.setText(flightStatus.getText());
            bookingDateF.setText(bookingDate.getText());
            phoneNumberF.setText(phoneNumber.getText());
            checkinTimeF.setText(checkinTime.getText());
            checkoutTimeF.setText(checkoutTime.getText());
            priceF.setText(price.getText());
            addressF.setText(address.getText());
            emailF.setText(email.getText());
            numAdultsF.setText(numAdults.getText());
            numKidsF.setText(numKids.getText());
            paymentMethodF.setText(paymentMethod.getText());

            toggleVisibility(true);

            editButton.setText("Save");
        }

        isEditing = !isEditing;
    }
    private void toggleVisibility(boolean showTextFields) {
        flightRoute.setVisible(!showTextFields);
        flightRouteF.setVisible(showTextFields);

        flightTime.setVisible(!showTextFields);
        flightTimeF.setVisible(showTextFields);

        airlineName.setVisible(!showTextFields);
        airlineNameF.setVisible(showTextFields);

        flightNumber.setVisible(!showTextFields);
        flightNumberF.setVisible(showTextFields);

        passengerName.setVisible(!showTextFields);
        passengerNameF.setVisible(showTextFields);

        flightStatus.setVisible(!showTextFields);
        flightStatusF.setVisible(showTextFields);

        bookingDate.setVisible(!showTextFields);
        bookingDateF.setVisible(showTextFields);

        phoneNumber.setVisible(!showTextFields);
        phoneNumberF.setVisible(showTextFields);

        checkinTime.setVisible(!showTextFields);
        checkinTimeF.setVisible(showTextFields);

        checkoutTime.setVisible(!showTextFields);
        checkoutTimeF.setVisible(showTextFields);

        price.setVisible(!showTextFields);
        priceF.setVisible(showTextFields);

        address.setVisible(!showTextFields);
        addressF.setVisible(showTextFields);

        email.setVisible(!showTextFields);
        emailF.setVisible(showTextFields);

        numAdults.setVisible(!showTextFields);
        numAdultsF.setVisible(showTextFields);

        numKids.setVisible(!showTextFields);
        numKidsF.setVisible(showTextFields);

        paymentMethod.setVisible(!showTextFields);
        paymentMethodF.setVisible(showTextFields);
    }
    @FXML
    protected void navigateHome(){
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
    protected void navigateHotelClient(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/client-details.fxml"));

            Stage stage = (Stage) bookingBtn.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Flight details");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML
    protected void navigateClientFlight(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/client-details-flight.fxml"));

            Stage stage = (Stage) bookingBtn.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Flight details");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML
    private void handleMenuButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent newScene = null;
        if (event.getSource() == selectFlightBtn || event.getSource() == viewFlightDetailsBtn1 || event.getSource() == viewFlightDetailsBtn2) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/flight-details.fxml")));
        }
        else if (event.getSource() == viewHotelDetailsBtn || event.getSource() == viewHotelDetailsBtn1 || event.getSource() == viewHotelDetailsBtn2) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/hotel-details.fxml")));
        } else if (event.getSource() == backFlightListingButton) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/flight-listing.fxml")));
        }
        else if (event.getSource() == backTOFromHotel) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/all-history-booking.fxml")));
        }
        else if (event.getSource() == backHotelListingButton) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/hotel-listing.fxml")));
        }
        else if (event.getSource() == viewHotelBookBtn) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/hotel-book-details.fxml")));
        }
        else if (event.getSource() == viewFlightBookBtn) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/flight-book-details.fxml")));
        }
        else if (event.getSource() == backToHistoryListing) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/all-history-booking.fxml")));
        }

        if (newScene != null) {
            Scene scene = new Scene(newScene);
            stage.setScene(scene);
            stage.setTitle("My New Scene");
            stage.show();
        }
    }

//    private void loadChoiceBox(){
//        myChoiceBox.getItems().addAll(priceSorted);
//        myChoiceBox.setValue("Price");
//    }

}
