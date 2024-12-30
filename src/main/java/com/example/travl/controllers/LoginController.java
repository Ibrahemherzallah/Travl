package com.example.travl.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    private Connection connection;

    @FXML
    public void initialize() {
        try {
            String url = "jdbc:mysql://localhost:3308/ahmedadelddb";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Unable to connect to the database.", Alert.AlertType.ERROR);
        }

        signInButton.setOnAction(this::handleSignIn);
    }

    private void handleSignIn(ActionEvent event) {
        String email = emailField.getText().trim();
        String password = passwordField.getText().trim();

        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Email and Password must not be empty.", Alert.AlertType.ERROR);
            return;
        }

        try {
            String query = "SELECT r.name AS role_name FROM user u " +
                    "JOIN user_roles ur ON u.id = ur.user_id " +
                    "JOIN role r ON ur.role_id = r.id " +
                    "WHERE u.email = ? AND u.password = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String roleName = resultSet.getString("role_name");
                navigateToDashboard(event, roleName);
            } else {
                showAlert("Error", "Invalid email or password.", Alert.AlertType.ERROR);
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred during login.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    protected void navigateToDashboard(ActionEvent event, String roleName) {
        try {
            FXMLLoader loader = null;
            String fxmlPath = "";

            if ("Admin".equalsIgnoreCase(roleName)) {
                fxmlPath = "/com/example/travl/admin-dash.fxml";
            } else if ("Employee".equalsIgnoreCase(roleName)) {
                fxmlPath = "/com/example/travl/agent-dash.fxml";
            } else {
                showAlert("Error", "Unknown role: " + roleName, Alert.AlertType.ERROR);
                return;
            }

            loader = new FXMLLoader(getClass().getResource(fxmlPath));

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Dashboard - " + roleName);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Unable to navigate to the dashboard.", Alert.AlertType.ERROR);
        }
    }
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}