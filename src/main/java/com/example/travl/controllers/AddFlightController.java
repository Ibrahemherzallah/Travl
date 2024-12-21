package com.example.travl.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
}
