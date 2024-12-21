package com.example.travl.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddHotelController {
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



    private void setVisibilityHotel() {
        dis_lab.setVisible(promotionCheckBox.isSelected());
        dur_lab.setVisible(promotionCheckBox.isSelected());
        dis_txt.setVisible(promotionCheckBox.isSelected());
        dur_txt.setVisible(promotionCheckBox.isSelected());

    }
    @FXML
    private ImageView img2;
    @FXML
    private void getImage2() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF & PNG Images", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            img2.setImage(new Image(chooser.getSelectedFile().getAbsolutePath()));
        }
    }
}

