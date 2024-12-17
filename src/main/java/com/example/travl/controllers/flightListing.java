package com.example.travl.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class flightListing implements Initializable {

    @FXML
    private ChoiceBox<String> ch1;
    @FXML
    private ChoiceBox<String> ch2;
    @FXML
    private ChoiceBox<String> ch3;
    @FXML
    private Button backButton;


    private final String[] flightDuration = {"Under 2 hours", "2-4 hours", "4-8 hours", "over 8 hours"};
    private final String[] Airlines = {"Delta Airlines", "United Airlines", "American Airlines"};
    private final String[] stops = {"Non-Stop", "1 stop", "2+stop"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ch1.setValue("Any duration");
        ch1.getItems().addAll(flightDuration);
        ch2.setValue("All Airlines");
        ch2.getItems().addAll(Airlines);
        ch3.setValue("Any");
        ch3.getItems().addAll(stops);

    }


    @FXML
    private void handleBackButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/HotelDetails.fxml"));

            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}
