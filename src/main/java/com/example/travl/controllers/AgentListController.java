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

public class AgentListController {



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



}
