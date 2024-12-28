package com.example.travl.controllers;
import com.example.travl.models.Agent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Objects;




public class AddController {

    @FXML
    private TableView<Agent> agentTable;

    @FXML
    private TableColumn<Agent, String> nameColumn;

    @FXML
    private TableColumn<Agent, String> emailColumn;

    @FXML
    private TableColumn<Agent, String> phoneColumn;

    @FXML
    private ImageView img1;
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

    public void initialize() {
        // Set up table columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("owner_address"));

        // Load data into the TableView
        loadAgentData();
    }
    private void loadAgentData() {
        ObservableList<Agent> agentList = FXCollections.observableArrayList();

        // Database connection parameters
        String jdbcURL = "jdbc:mysql://localhost:3306/travl_db";
        String username = "root";
        String password = "@@@Dy123321";

        String query = "SELECT name, email, owner_address FROM agent";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String ownerAddress = resultSet.getString("owner_address");

                Agent agent = new Agent();
                agent.setName(name);
                agent.setEmail(email);
                agent.setOwner_address(ownerAddress);

                agentList.add(agent);
            }

            agentTable.setItems(agentList);

        } catch (SQLException e) {
            System.err.println("Error fetching agent data: " + e.getMessage());
            e.printStackTrace();
        }
    }


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
    @FXML
    protected void navigateHome(){
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
    @FXML
    protected void navigateFlight(){
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
    @FXML
    protected void navigateHotel(){
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
    @FXML
    protected void navigateHistory(){
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
    private void getImage1() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF & PNG Images", "jpg", "gif","png");
        chooser.setFileFilter(filter);
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            img1.setImage(new Image(chooser.getSelectedFile().getAbsolutePath()));
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
