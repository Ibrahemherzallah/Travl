package com.example.travl.controllers;

import com.example.travl.models.Customer;
import com.example.travl.models.Flight;
import com.example.travl.models.Hotel;
import com.example.travl.models.services.CustomerDOAImp;
import com.example.travl.models.services.FlightDOAImp;
import com.example.travl.models.services.HotelDOAImp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;

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

    @FXML
    public void initialize(Customer customer) {
        this.customer = customer;
    }

    public void setBookingDetails(String name, String e_mail,String phone) {
        destinationLabel.setText(name);
        dateLabel.setText(e_mail);
        hotelLabel.setText(phone);
    }

    @FXML
    private void handleConfirm() {
        //static id
        int id = 24;
        Hotel hotel = hotelDOAImp.getHotelByID(id);
        if(hotel.getAvailableRooms() > 0) {
            customerDOAImp.insert(customer);
            hotel.setAvailableRooms(hotel.getAvailableRooms() - 1);
            hotelDOAImp.update(hotel);
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
        Flight flight = flightDOAImp.getFlightlByID(id);

            customerDOAImp.insert(customer);
            flight.setNumberOfPassengers(flight.getNumberOfPassengers() + 1);
            flightDOAImp.update(flight);

            System.out.println("aadded Confirmed!");

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
