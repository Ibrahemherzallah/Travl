package com.example.travl.controllers;

import com.example.travl.models.Customer;
import com.example.travl.models.Hotel;
import com.example.travl.models.services.CustomerDOAImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
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
    @FXML private Button backButtonFlight;
    @FXML private Button confirmButtonFlight;


    Customer customer = new Customer();
    @FXML
    protected void onBook(ActionEvent event) {

        if (!firstNameField.getText().matches("^[a-zA-Z ]+$")) {
            JOptionPane.showMessageDialog(null, "First Name should not be Integers or Empty");
        }
        else if (!lastNameField.getText().matches("^[a-zA-Z ]+$")) {
            JOptionPane.showMessageDialog(null, " Last Name should not be Integers ");
        }
        else if (!addressField.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ,]+$")) {
            JOptionPane.showMessageDialog(null, "Adress should not be Integers or Empty");
        }
        else if (!cityField.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ,]+$")) {
            JOptionPane.showMessageDialog(null, "City should not be Integers or Empty");
        }
        else if (!phoneNumberField.getText().matches("^9705\\d{8}$")) {
            JOptionPane.showMessageDialog(null, "Phone Should be start with 9705 and 8 digits after that ");
        }
        else if (!emailField.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Invalid email address. Please enter a valid email (e.g., example@example.com).");
        }
        else if (!numberOfAdultsField.getText().matches("^[1-5]$")) {
            JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 5 in Number of Adults Field ");
        }
        else if (!numberOfKidsField.getText().matches("^[1-5]?$")) {
            JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 5 in Number of Kids Field ");
        }

        else if (!paymentCheck.isSelected()&&!paymentPaypal.isSelected())  {
            JOptionPane.showMessageDialog(null, "Please check 1 of the payment");
        }
     else if (paymentCheck.isSelected()&&paymentPaypal.isSelected())  {
        JOptionPane.showMessageDialog(null, "Please check 1 of the payment");
    }



        else {
            customer.setFirst_name(firstNameField.getText());
            customer.setLast_name(lastNameField.getText());
            customer.setAddress(addressField.getText());
            customer.setCity(cityField.getText());
            customer.setPhone(phoneNumberField.getText());
            customer.setEmail(emailField.getText());
            customer.setNum_of_adults(Integer.parseInt(numberOfAdultsField.getText()));
            customer.setNum_of_kids(Integer.parseInt(numberOfKidsField.getText()));
            customer.setCash(paymentCheck.isSelected());
            customer.setPaypal(paymentPaypal.isSelected());
            customer.setSpecial_requests(specialRequestField.getText());
            openConfirmationModal();


        }
    }

    @FXML
    protected void onBookFlight(ActionEvent event) {

        if (!firstNameField.getText().matches("^[a-zA-Z ]+$")) {
            JOptionPane.showMessageDialog(null, "First Name should not be Integers or Empty");
        }
        else if (!lastNameField.getText().matches("^[a-zA-Z ]+$")) {
            JOptionPane.showMessageDialog(null, " Last Name should not be Integers ");
        }
        else if (!addressField.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ,]+$")) {
            JOptionPane.showMessageDialog(null, "Adress should not be Integers or Empty");
        }
        else if (!cityField.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ,]+$")) {
            JOptionPane.showMessageDialog(null, "City should not be Integers or Empty");
        }
        else if (!phoneNumberField.getText().matches("^9705\\d{8}$")) {
            JOptionPane.showMessageDialog(null, "Phone Should be start with 9705 and 8 digits after that ");
        }
        else if (!emailField.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Invalid email address. Please enter a valid email (e.g., example@example.com).");
        }
        else if (!numberOfAdultsField.getText().matches("^[1-5]$")) {
            JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 5 in Number of Adults Field ");
        }
        else if (!numberOfKidsField.getText().matches("^[1-5]?$")) {
            JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 5 in Number of Kids Field ");
        }

        else if (!paymentCheck.isSelected()&&!paymentPaypal.isSelected())  {
            JOptionPane.showMessageDialog(null, "Please check 1 of the payment");
        }
        else if (paymentCheck.isSelected()&&paymentPaypal.isSelected())  {
            JOptionPane.showMessageDialog(null, "Please check 1 of the payment");
        }



        else {

            customer.setFirst_name(firstNameField.getText());
            customer.setLast_name(lastNameField.getText());
            customer.setAddress(addressField.getText());
            customer.setCity(cityField.getText());
            customer.setPhone(phoneNumberField.getText());
            customer.setEmail(emailField.getText());
            customer.setNum_of_adults(Integer.parseInt(numberOfAdultsField.getText()));
            customer.setNum_of_kids(Integer.parseInt(numberOfKidsField.getText()));
            customer.setCash(paymentCheck.isSelected());
            customer.setPaypal(paymentPaypal.isSelected());
            customer.setSpecial_requests(specialRequestField.getText());
            openConfirmationFlight();


        }
    }

    private void openConfirmationModal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/booking-confirmation.fxml"));
            Parent root = loader.load();
            ConfirmationController confirmationController = loader.getController();
            confirmationController.initialize(customer);
            confirmationController.setBookingDetails(
                    firstNameField.getText() + " " + lastNameField.getText(),
                     emailField.getText(),
                    phoneNumberField.getText()
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

    private void openConfirmationFlight() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/booking-confirmation-flight.fxml"));
            Parent root = loader.load();
            ConfirmationController confirmationController = loader.getController();
            confirmationController.initialize(customer);
            confirmationController.setBookingDetails(
                    firstNameField.getText() + " " + lastNameField.getText(),
                    emailField.getText(),
                    phoneNumberField.getText()
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/hotel-details.fxml"));
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
    private void handleBackButtonFlight(ActionEvent event) {
        System.out.println("FROMM FLIGHT");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/flight-details.fxml"));
            Stage stage = (Stage) backButtonFlight.getScene().getWindow();
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
    }
}
