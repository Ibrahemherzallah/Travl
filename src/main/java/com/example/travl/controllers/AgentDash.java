package com.example.travl.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AgentDash{

    @FXML private ImageView homeIcon;
    @FXML private ImageView flightIcon;
    @FXML private ImageView hotelIcon;
    @FXML private ImageView historyIcon;
    @FXML
    public void handleMenuButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((ImageView) event.getSource()).getScene().getWindow();
        Parent newScene = null;
        if (event.getSource() == homeIcon) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/agent-dash.fxml")));
        } else if (event.getSource() == flightIcon) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/flight-listing.fxml")));
        } else if (event.getSource() == hotelIcon) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/hotel-listing.fxml")));
        } else if (event.getSource() == historyIcon) {
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