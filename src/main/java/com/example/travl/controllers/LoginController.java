package com.example.travl.controllers;

import com.example.travl.models.User;
import com.example.travl.models.services.UserDOAImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class LoginController {

    public CheckBox rememberMeCheckBox;
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private Hyperlink signUpLink;

    @FXML
    public void initialize() {
        signInButton.setOnAction(this::handleSignIn);
        signUpLink.setOnAction(this::handleForgetPassword);
    }

    @FXML
    void test(){
        UserDOAImp userDOAImp = new UserDOAImp();
        List<User> all_users = userDOAImp.getAll();
        all_users.forEach(e -> System.out.println(e.getFirstName() + e.getLastName()));
    }

    private void handleSignIn(ActionEvent event) {
        try {
            Parent dashboardRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/agent-dash.fxml")));
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(dashboardRoot));
            stage.setTitle("Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading Dashboard page.");
        }
    }
    private void handleForgetPassword(ActionEvent event) {
        try {
            Parent forgetPasswordRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/forget-password.fxml")));
            Stage stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(forgetPasswordRoot));
            stage.setTitle("Forget Password");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading Forget Password page.");
        }
    }
}
