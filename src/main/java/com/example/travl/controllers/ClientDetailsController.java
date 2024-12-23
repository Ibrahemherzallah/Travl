package com.example.travl.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientDetailsController {

    @FXML private Button backButton;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField addressField;
    @FXML private TextField cityField;
    @FXML private TextField phoneNumberField;
    @FXML private TextField emailField;
    @FXML private TextField numberOfAdultsField;
    @FXML private TextField numberOfKidsField;
    @FXML private CheckBox paymentCheck;
    @FXML private CheckBox paymentPaypal;
    @FXML private TextArea specialRequestField;
    @FXML private Button bookButton;

    @FXML
    public void handleBooking(ActionEvent event) {
        openConfirmationModal();
    }

    private void openConfirmationModal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/booking-confirmation.fxml"));
            Parent root = loader.load();
            ConfirmationController confirmationController = loader.getController();
            confirmationController.setBookingDetails(
                    firstNameField.getText() + " " + lastNameField.getText(),
                    "Date: " + cityField.getText(),
                    "Hotel: " + emailField.getText(),
                    "Total Price: Confirmed"
            );
            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.setTitle("Booking Confirmation");
            modalStage.setScene(new Scene(root));
            modalStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/flight-listing.fxml"));
            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading login page.");
        }
    }

    @FXML
    public void initialize() {
        System.out.println("ClientDetailsController initialized");
        bookButton.setOnAction(this::handleBooking);
    }
}
