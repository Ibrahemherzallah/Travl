package com.example.travl.controllers;

import com.example.travl.models.User;
import com.example.travl.models.services.AuthorizationService;
import com.example.travl.models.services.UserDOAImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    private static SessionFactory sessionFactory;
    private final AuthorizationService authorizationService = new AuthorizationService();

    @FXML
    public void initialize() {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Unable to initialize Hibernate.", Alert.AlertType.ERROR);
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

        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User u WHERE u.email = :email AND u.password = :password";
            User user = session.createQuery(hql, User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .uniqueResult();

            if (user != null && user.getRole() != null) {
                if (authorizationService.hasPermission(user, "View Dashboard")) {
                    navigateToDashboard(event, user.getRole().getName());
                } else {
                    showAlert("Error", "You do not have permission to access the dashboard.", Alert.AlertType.ERROR);
                }
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
            } else if ("User".equalsIgnoreCase(roleName)) {
                fxmlPath = "/com/example/travl/user-dash.fxml";
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
