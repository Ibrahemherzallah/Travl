package com.example.travl.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashController {

    @FXML private ImageView homeIconAD;
    @FXML private ImageView flightIconAD;
    @FXML private ImageView hotelIconAD;
    @FXML private ImageView addAgentAD;
    @FXML private ImageView addFlightAD;
    @FXML private ImageView addHotelAD;

    @FXML protected void navigateHomeAD(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/admin-dash.fxml"));

            Stage stage = (Stage) homeIconAD.getScene().getWindow();
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
    protected void navigateFlightAD(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/flight-listing.fxml"));

            Stage stage = (Stage) flightIconAD.getScene().getWindow();
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
    protected void navigateHotelAD(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/hotel-listing.fxml"));

            Stage stage = (Stage) hotelIconAD.getScene().getWindow();
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
    protected void navigateAddAgentAD(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/add-agent-page.fxml"));

            Stage stage = (Stage) addAgentAD.getScene().getWindow();
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
    protected void navigateAddFlightAD(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/add-flight.fxml"));

            Stage stage = (Stage) addFlightAD.getScene().getWindow();
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
    protected void navigateAddHotelAD(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/add-hotel.fxml"));

            Stage stage = (Stage) addFlightAD.getScene().getWindow();
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