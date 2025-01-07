package com.example.travl.controllers;

import com.example.travl.models.*;
import com.example.travl.models.services.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class ConfirmationController {

    public Button confirmButtonFlight;
    @FXML private Label destinationLabel;
    @FXML private Label dateLabel;
    @FXML private Label hotelLabel;
    @FXML private Label totalPriceLabel;
    @FXML private Button confirmButton;
    @FXML private Button cancelButton;
    @FXML private Button cancelFlightButton;

    Customer customer = new Customer();
    CustomerDOAImp customerDOAImp = new CustomerDOAImp();
    HotelDOAImp hotelDOAImp = new HotelDOAImp();
    FlightDOAImp flightDOAImp = new FlightDOAImp();
    BookingServiceDOAImp bookingServiceDOAImp = new BookingServiceDOAImp();
    UserDOAImp userDOAImp = new UserDOAImp();
    @FXML
    public void initialize(Customer customer) {
        this.customer = customer;
    }

    public void setBookingDetails(String name, String e_mail,String phone) {
        destinationLabel.setText(name);
        dateLabel.setText(e_mail);
        hotelLabel.setText(phone);
    }
BookingService bookingService=new BookingService();

    @FXML
    private void handleConfirm() {
        //static id
        int id = 22;
        int UserID= 1;
        Hotel hotel = hotelDOAImp.getHotelByID(id);
        User user =userDOAImp.findUser(UserID);
        if(hotel.getAvailableRooms() > 0) {
            customerDOAImp.insert(customer);
            hotel.setAvailableRooms(hotel.getAvailableRooms() - 1);
            hotelDOAImp.update(hotel);
            bookingService.setHotel(hotel);
            bookingService.setBooking_type("Hotel");
            bookingService.setUser(user);
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            bookingService.setCreated_at(date);
            bookingServiceDOAImp.insert(bookingService);


            System.out.println("Booking Confirmed!");
        }
        else {
            JOptionPane.showMessageDialog(null, "no available rooms ");
        }
        closeHotelModal();
    }

    @FXML
    private void handleConfirmFlight() {
        int id = 28;
        int UserID= 1;
        Flight flight = flightDOAImp.getFlightlByID(id);
        User user =userDOAImp.findUser(UserID);
            customerDOAImp.insert(customer);
            flight.setNumberOfPassengers(flight.getNumberOfPassengers() + 1);
            flightDOAImp.update(flight);
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            bookingService.setCreated_at(date);
            bookingService.setFlight(flight);
            bookingService.setUser(user);
            bookingService.setBooking_type("Flight");
            bookingServiceDOAImp.insert(bookingService);


        System.out.println("added Confirmed!");

        closeFlightModal();
        }


    private void closeHotelModal() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private void closeFlightModal() {
        Stage stage = (Stage) cancelFlightButton.getScene().getWindow();
        stage.close();
    }
}
