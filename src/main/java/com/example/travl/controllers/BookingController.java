package com.example.travl.controllers;

import com.example.travl.models.BookingService;
import com.example.travl.models.Flight;
import com.example.travl.models.Hotel;
import com.example.travl.models.services.BookingServiceDOAImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class BookingController {

    @FXML private Label ticket_type_v1;
    @FXML private Label destination_history_name_v1;
    @FXML private Label takeOf_date_v1;
    @FXML private Label bookingID_v1;
    @FXML private Label status_v1;
    @FXML private Label ticketPrice_v1;

    @FXML private Label ticket_type_v2;
    @FXML private Label destination_history_name_v2;
    @FXML private Label takeOf_date_v2;
    @FXML private Label bookingID_v2;
    @FXML private Label status_v2;
    @FXML private Label ticketPrice_v2;






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
    ///
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
    private BookingServiceDOAImp bookingServiceDOA;
    private SessionFactory sessionFactory;

    @FXML
    public void initialize() {
        try {
            bookingServiceDOA = new BookingServiceDOAImp();
            loadBooking("FL123456789", 1);
            loadBooking("FL456123789", 2);
            loadBooking("HT987654321", 3);
            loadBooking("HT1234567890", 4);
            loadBooking("HT4561237890", 5);
            loadBooking("FL9876543210", 6);
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Initialization Error", "Failed to initialize booking service. Check logs for details.", Alert.AlertType.ERROR);
        }
    }


    private void loadBooking(String bookingID, int id) {
        try {
            BookingService bookingService = bookingServiceDOA.findBooking(bookingID);
            if (bookingService != null) {
                // Check if the booking is for a flight or hotel and display accordingly
                if (bookingService.getFlight() != null) {
                    displayFlightBooking(bookingService, bookingID, id);
                } else if (bookingService.getHotel() != null) {
                    displayHotelBooking(bookingService, bookingID, id);
                }
            } else {
                System.out.println("NO BOOKING FOUND WITH THIS ID: " + bookingID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayFlightBooking(BookingService bookingService, String bookingID, int id) {
        Flight flight = bookingService.getFlight();
        if (flight != null) {
            // Display flight booking details
            if (id == 1) {
                ticket_type_v1.setText("Flight Booking");
                destination_history_name_v1.setText(flight.getDestination());
                takeOf_date_v1.setText(flight.getDepartureDate().toString());
                bookingID_v1.setText("Booking ID: " + bookingID);
                status_v1.setText("Confirmed");
                ticketPrice_v1.setText(flight.getTicketPrice() + "$");
            }
            // Repeat for other id checks if needed
        }
    }

    private void displayHotelBooking(BookingService bookingService, String bookingID, int id) {
        Hotel hotel = bookingService.getHotel();
        if (hotel != null) {
            // Display hotel booking details
            if (id == 3) {
                ticket_type_v1.setText("Hotel Booking");
                destination_history_name_v1.setText(hotel.getLocation());
                takeOf_date_v1.setText(hotel.getCreated_at().toString());
                bookingID_v1.setText("Booking ID: " + bookingID);
                status_v1.setText("Confirmed");
                ticketPrice_v1.setText(hotel.getPricePerNight() + "$");
            }
            // Repeat for other id checks if needed
        }
    }


    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
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
    protected void navigateClient(){
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




}