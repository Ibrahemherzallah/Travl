package com.example.travl.controllers;
import com.example.travl.models.Hotel;
import com.example.travl.models.Role;
import com.example.travl.models.User;
import com.example.travl.models.services.UserDOAImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class AddController {
    @FXML private ImageView homeIcon;
    @FXML private ImageView flightIcon;
    @FXML private ImageView hotelIcon;
    @FXML private ImageView historyIcon;
    @FXML private ImageView homeIconAD;
    @FXML private ImageView flightIconAD;
    @FXML private ImageView hotelIconAD;
    @FXML private ImageView addAgentAD;
    @FXML private ImageView addFlightAD;
    @FXML private ImageView addHotelAD;

    @FXML private TextField agentFirstName;
    @FXML private TextField agentLastName;
    @FXML private PasswordField agentPass;
    @FXML private TextField agentAddress;
    @FXML private TextField agentEmail;
    @FXML private TextField agentPhone;
    @FXML private TextField agentOwnerId;
    @FXML private DatePicker agentCreatedDate;

    @FXML protected void navigateHomeAD(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/admin-dash.fxml"));

            Stage stage = (Stage) homeIconAD.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML protected void navigateFlightAD(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/flight-listing-admin.fxml"));

            Stage stage = (Stage) flightIconAD.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML protected void navigateHotelAD(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/hotel-listing-admin.fxml"));

            Stage stage = (Stage) hotelIconAD.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML protected void navigateAddAgentAD(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/add-agent-page.fxml"));

            Stage stage = (Stage) addAgentAD.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML protected void navigateAddFlightAD(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/add-flight.fxml"));

            Stage stage = (Stage) addFlightAD.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML protected void navigateAddHotelAD(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/add-hotel.fxml"));

            Stage stage = (Stage) addFlightAD.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML protected void navigateHome(){
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
    @FXML protected void navigateFlight(){
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
    @FXML protected void navigateHotel(){
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
    @FXML protected void navigateHistory(){
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
    protected void addAgent(ActionEvent event) throws IOException{

        if (!agentFirstName.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ]+$") || !agentLastName.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ]+$")) {
                JOptionPane.showMessageDialog(null, "Agent Name should not be Integers or Empty");
            }
            else if (!agentPass.getText().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")) {
                JOptionPane.showMessageDialog(null, "Password must be 8-20 characters long, include at least one uppercase letter, one lowercase letter, one digit, and one special character.");
            }
            else if (!agentEmail.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                JOptionPane.showMessageDialog(null, "Invalid email address. Please enter a valid email (e.g., example@example.com).");
            }
            else if (!agentPhone.getText().matches("^9705\\d{8}$")) {
                JOptionPane.showMessageDialog(null, "Phone Should be start with 9705 and 8 digits after that ");
            }
            else if (!agentAddress.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ,]+$")){
                JOptionPane.showMessageDialog(null, "Owner address address should not be Integers or Empty");
            }
            else if (!agentOwnerId.getText().matches("^\\d{9}$")) {
                JOptionPane.showMessageDialog(null, "Owner ID must be exactly 9 digits long.");
            }
            else if (agentCreatedDate.getValue() == null) {
                JOptionPane.showMessageDialog(null, "Dates cant be empty ");
            }
            else {
                UserDOAImp userDOAImp = new UserDOAImp();
                Role agentRole = new Role();
                agentRole.setId(2L);
                User agent = new User();
                agent.setFirstName(agentFirstName.getText());
                agent.setLastName(agentLastName.getText());
                agent.setEmail(agentEmail.getText());
                agent.setPassword(agentPass.getText());
                agent.setOwner_id(agentOwnerId.getText());
                agent.setPhone(agentPhone.getText());
                agent.setAddress(agentAddress.getText());
                agent.setCreated_at(java.sql.Date.valueOf(agentCreatedDate.getValue()));
                agent.setRole(agentRole);
                if(chooser.getSelectedFile() != null){
                    File imageFile = new File(chooser.getSelectedFile().getAbsolutePath());
                    FileInputStream inputStream = new FileInputStream(imageFile);
                    agent.setImg(inputStream);
                }
                userDOAImp.insert(agent);
            }
        goBackToAdminDash(event);
    }


    @FXML private ImageView img2;
    JFileChooser chooser = new JFileChooser();
    @FXML
    private void getImage() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF & PNG Images", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            img2.setImage(new Image(chooser.getSelectedFile().getAbsolutePath()));
        }
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

}
