package com.example.travl.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.util.Objects;

public class AddAgentController { @FXML
private ImageView img1;



    @FXML
    private void getImage1() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF & PNG Images", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            img1.setImage(new Image(chooser.getSelectedFile().getAbsolutePath()));
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
}
