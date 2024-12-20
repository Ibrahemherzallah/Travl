package com.example.travl.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.util.Objects;

public class AddController {
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img1;
    @FXML private ImageView homeIcon;
    @FXML private ImageView flightIcon;
    @FXML private ImageView hotelIcon;
    @FXML private ImageView historyIcon;

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
    private void getImage2() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF & PNG Images", "jpg", "gif","png");
        chooser.setFileFilter(filter);
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            img2.setImage(new Image(chooser.getSelectedFile().getAbsolutePath()));
        }
    }

    @FXML
    private void getImage1() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF & PNG Images", "jpg", "gif","png");
        chooser.setFileFilter(filter);
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            img1.setImage(new Image(chooser.getSelectedFile().getAbsolutePath()));
        }
    }

    @FXML
    private void showAddAgent(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent newScene = null;
        newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/add-agent-page.fxml")));
        if (newScene != null) {
            Scene scene = new Scene(newScene);
            stage.setScene(scene);
            stage.setTitle("Add Agent");
            stage.show();
        }
    }
    @FXML
    private void goBackToAgentList(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent newScene = null;
        newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/agent-list.fxml")));
        if (newScene != null) {
            Scene scene = new Scene(newScene);
            stage.setScene(scene);
            stage.setTitle("Agent List");
            stage.show();
        }
    }
    @FXML
    private CheckBox promotionCheckBox1;
    @FXML
    private CheckBox promotionCheckBox;
    @FXML
    private Label dis_lab;
    @FXML
    private Label dur_lab;
    @FXML
    private TextField dis_txt;
    @FXML
    private TextField dur_txt;
    @FXML

    private Label dis_lab1;
    @FXML
    private Label dur_lab1;
    @FXML
    private TextField dis_txt1;
    @FXML
    private TextField dur_txt1;
    @FXML


    private void setVisibilityHotel() {
        dis_lab.setVisible(promotionCheckBox.isSelected());
        dur_lab.setVisible(promotionCheckBox.isSelected());
        dis_txt.setVisible(promotionCheckBox.isSelected());
        dur_txt.setVisible(promotionCheckBox.isSelected());

    }
    @FXML
    private void setVisibilityFlight() {
        dis_lab1.setVisible(promotionCheckBox1.isSelected());
        dur_lab1.setVisible(promotionCheckBox1.isSelected());
        dis_txt1.setVisible(promotionCheckBox1.isSelected());
        dur_txt1.setVisible(promotionCheckBox1.isSelected());
    }
    }
