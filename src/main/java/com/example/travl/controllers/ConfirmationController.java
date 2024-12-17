package com.example.travl.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ConfirmationController {

    @FXML private Label destinationLabel;
    @FXML private Label dateLabel;
    @FXML private Label hotelLabel;
    @FXML private Label totalPriceLabel;

    @FXML private Button confirmButton;
    @FXML private Button cancelButton;

    @FXML
    public void initialize() {
        confirmButton.setOnAction(event -> handleConfirm());
        cancelButton.setOnAction(event -> handleCancel());
    }

    public void setBookingDetails(String destination, String date, String hotel, String totalPrice) {
        destinationLabel.setText(destination);
        dateLabel.setText(date);
        hotelLabel.setText(hotel);
        totalPriceLabel.setText(totalPrice);
    }

    private void handleConfirm() {
        System.out.println("Booking Confirmed!");
        closeModal();
    }

    private void handleCancel() {
        System.out.println("Booking Cancelled.");
        closeModal();
    }

    private void closeModal() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
