package com.example.travl.controllers;

import com.example.travl.models.Flight;
import com.example.travl.models.services.FlightDOAImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class AddFlightController {

    FlightDOAImp flightDOAImp = new FlightDOAImp();

    @FXML
    protected void onSubmitButtonClick(ActionEvent event) throws IOException {
        try {
            System.out.println("the form text is" + des_from.getText());
            if (!flightNameField.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ]+$")) {
                JOptionPane.showMessageDialog(null, "Flight Name should not be Integers or Empty");
            }
            else if (!airlineField.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ,]+$")) {
                JOptionPane.showMessageDialog(null, " Air Line should not be Integers or Empty");
            }

            else if(!destinationField.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ,]+$")){
                JOptionPane.showMessageDialog(null, "Destination should not be Integers or Empty");
            }


            else if(!des_from.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ,]+$")){
                JOptionPane.showMessageDialog(null, "Destination should not be Integers or Empty");
            }
            else if(durationField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, " Flight Duration should not be Empty");
            }

            else  if(!priceField.getText().matches("^(50000|[1-4]?[0-9]{1,4})$")){
                JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 50000 in Price Field");
            }
            else  if(!numberOfPassengersField.getText().matches("^(200|[1-9]?[0-9]|1[0-9]{2})$")){
                JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 200 in Number of Passenger Field");
            }
            else  if(!stopField.getText().matches("^[1-9][0-9]?$")){
                JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 100 in Stops Field");
            }

            else if (arrivalDateField.getValue()== null ||departureDateField.getValue()== null ||creatAtField.getValue()==null) {
                JOptionPane.showMessageDialog(null, "Dates cant be empty ");
            }

            else if(departureDateField.getValue().isAfter(arrivalDateField.getValue())){
                JOptionPane.showMessageDialog(null, "Departure Date cant be after Arrival Date ");
            }
            else if(creatAtField.getValue().isAfter(departureDateField.getValue())){
                JOptionPane.showMessageDialog(null, "Creation Date cant be after Departure Date ");

            }
            else {
                Flight flight = new Flight();
                flight.setFlightName(flightNameField.getText());
                flight.setAirline(airlineField.getText());
                flight.setDestination(destinationField.getText());
               // flight.setFrom(des_from.getText());
                flight.setDuration(durationField.getText());
                flight.setNumberOfPassengers(Integer.parseInt(numberOfPassengersField.getText()));
                flight.setStops(stopField.getText());
                flight.setArrivalDate(java.sql.Date.valueOf(arrivalDateField.getValue()));
                flight.setDepartureDate(java.sql.Date.valueOf(departureDateField.getValue()));
                flight.setCreatedAt(java.sql.Date.valueOf(creatAtField.getValue()));
                flight.setTicketPrice(Integer.parseInt(priceField.getText()));
                flight.setPromotion(promotionCheckBox1.isSelected());

                if ((promotionCheckBox1.isSelected())) {
                    if (!dis_txt1.getText().matches("^[1-9][0-9]?$")) {
                        JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 99 in Discount Field");
                        return;
                    }
                    flight.setDiscount(dis_txt1.getText());

                    if (!dur_txt1.getText().matches("^(100|[1-9]?[0-9])$")) {
                        JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 100 in Duration Field");
                        return;
                    }
                    flight.setPromotionDuration(Integer.parseInt(dur_txt1.getText()));

                }

                flightDOAImp.insert(flight);
                goBackToAdminDash(event);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }

    }

    @FXML
    private TextField flightNameField;

    @FXML
    private TextField airlineField;
    @FXML
    private TextField destinationField;
    @FXML
    private TextField durationField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField numberOfPassengersField;
    @FXML
    private DatePicker departureDateField;
    @FXML
    private DatePicker arrivalDateField;
    @FXML
    private DatePicker creatAtField;
    @FXML
    private TextField stopField;
@FXML
private TextField des_from;
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
    private Button submit_btn;
    @FXML
    private void setVisibilityFlight() {
        dis_lab1.setVisible(promotionCheckBox1.isSelected());
        dur_lab1.setVisible(promotionCheckBox1.isSelected());
        dis_txt1.setVisible(promotionCheckBox1.isSelected());
        dur_txt1.setVisible(promotionCheckBox1.isSelected());
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



}
