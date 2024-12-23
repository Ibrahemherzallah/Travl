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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AddFlightController {
    @FXML
    private CheckBox promotionCheckBox1;
    @FXML
    private Label dis_lab1;
    @FXML
    private Label dur_lab1;
    @FXML
    private TextField dis_txt1;
    @FXML
    private TextField dur_txt1;
    @FXML
    private void setVisibilityFlight() {
        dis_lab1.setVisible(promotionCheckBox1.isSelected());
        dur_lab1.setVisible(promotionCheckBox1.isSelected());
        dis_txt1.setVisible(promotionCheckBox1.isSelected());
        dur_txt1.setVisible(promotionCheckBox1.isSelected());
    }
    @FXML
    private void goBackToAdminDash(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent newScene = null;
        newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/admin-dash.fxml")));
        if (newScene != null) {
            Scene scene = new Scene(newScene);
            stage.setScene(scene);
            stage.setTitle("Admin Dash");
            stage.show();
        }
    }

}
