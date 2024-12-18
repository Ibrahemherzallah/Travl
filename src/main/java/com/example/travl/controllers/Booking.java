package com.example.travl.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Booking {
    @FXML
    private Button viewFlight ;
    @FXML
    private Button viewFlight2 ;
    @FXML
    private Button viewHotel ;
    @FXML
    private Button backTOFromFlight;
    @FXML
    private Button backTOFromHotel;

    @FXML
    private void handleMenuButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent newScene = null;
        if (event.getSource() == viewFlight) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/flight-book-details.fxml")));
        }
        else if (event.getSource() == viewFlight2) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/flight-book-details.fxml")));
        }
 else if (event.getSource() == viewHotel) {
     newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/hotel-book-details.fxml")));
       }
        else if (event.getSource() == backTOFromFlight) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/all-history-booking.fxml")));
        }
        else if (event.getSource() == backTOFromHotel) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/all-history-booking.fxml")));
        }
////        } else if (event.getSource() == resetPassCodeBtn) {
////            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/reset-password-code.fxml")));
////        } else if (event.getSource() == backToLogInBtn) {
////            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/log-in.fxml")));
////        }
        if (newScene != null) {
            Scene scene = new Scene(newScene);
            stage.setScene(scene);
            stage.setTitle("My New Scene");
            stage.show();
        }
    }

}
