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

public class AuthController {

    @FXML private Button signInButton;
    @FXML private Button forgetPassButton;
    @FXML private Button resetPassCodeBtn;
    @FXML private Button backToLogInBtn;
    @FXML private Button resetPassBtn;
    @FXML private Button navigateToVerificationBtn;
    @FXML private Button newPassBtn;

    @FXML
    protected void handleMenuButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent newScene = null;
        if (event.getSource() == signInButton) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/agent-dash.fxml")));
        } else if (event.getSource() == forgetPassButton) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/forget-password.fxml")));
        } else if (event.getSource() == resetPassCodeBtn) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/reset-password.fxml")));
        } else if (event.getSource() == backToLogInBtn) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/log-in.fxml")));
        } else if (event.getSource() == navigateToVerificationBtn) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/verification-code.fxml")));
        } else if (event.getSource() == resetPassBtn) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/reset-password.fxml")));
        } else if (event.getSource() == newPassBtn) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/log-in.fxml")));
        }
        if (newScene != null) {
            Scene scene = new Scene(newScene);
            stage.setScene(scene);
            stage.setTitle("My New Scene");
            stage.show();
        }
    }
}
