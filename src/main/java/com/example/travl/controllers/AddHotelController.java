package com.example.travl.controllers;
import com.example.travl.models.Hotel;
import com.example.travl.models.services.HotelDOAImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;


public class AddHotelController {

    HotelDOAImp hotelDOAImp = new HotelDOAImp();

    @FXML
    protected void onSubmitButtonClick(ActionEvent event) throws IOException {


        if (!hotelNameField.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ]+$")) {
            JOptionPane.showMessageDialog(null, "Hotel Name should not be Integers or Empty");
        }
        else if (!hotelChainField.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ]*$|^$")) {
            JOptionPane.showMessageDialog(null, " Hotel Chain should not be Integers ");
        }

        else if (!locationField.getText().matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ,]+$")){
            JOptionPane.showMessageDialog(null, "Hotel Location should not be Integers or Empty");
        }

        else if (!ratingField.getText().matches("^[0-5]$")) {
            JOptionPane.showMessageDialog(null, "Please enter  integers between 0 and 5 in Rates Field");
        }
        else  if(!pricePerNightField.getText().matches("^(50000|[1-4]?[0-9]{1,4})$")){
            JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 50000 in Price Field");
        }

        else  if(!availableRoomsField.getText().matches("^(1000|[1-9][0-9]{0,2})$")){
            JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 1000 in Available Rooms Field");
        }


        else if (!phoneField.getText().matches("^9705\\d{8}$")) {
            JOptionPane.showMessageDialog(null, "Phone Should be start with 9705 and 8 digits after that ");
        }



        else if (descriptionField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Description cant be empty ");
        }
        else if (creatAtField.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Dates cant be empty ");
        }

        else
    {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelNameField.getText());
        hotel.setHotelChain(hotelChainField.getText());
        hotel.setLocation(locationField.getText());
        hotel.setNumOfStar(Integer.parseInt(ratingField.getText()));
        hotel.setAvailableRooms(Integer.parseInt(availableRoomsField.getText()));
        hotel.setPhone(phoneField.getText());
        //hotel.setPricePerNight(Integer.parseInt(pricePerNightField.getText()));
        hotel.setDescriptionWithAmenities(descriptionField.getText());
        hotel.setCreated_at(java.sql.Date.valueOf(creatAtField.getValue()));
        hotel.setPromotion(promotionCheckBox.isSelected());

        if ((promotionCheckBox.isSelected())) {
            if (!dis_txt.getText().matches("^[1-9][0-9]?$")) {
                JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 99 in Discount Field");
                return;
            }
            hotel.setDiscount(dis_txt.getText());

            if (!dur_txt.getText().matches("^(100|[1-9]?[0-9])$")) {
                JOptionPane.showMessageDialog(null, "Please enter a  number between 1 and 100 in Duration Field");
                return;
            }
            hotel.setPromotionDuration(Integer.parseInt(dur_txt.getText()));

        }
        if(chooser.getSelectedFile() != null){
            File imageFile = new File(chooser.getSelectedFile().getAbsolutePath());
            FileInputStream inputStream = new FileInputStream(imageFile);
            hotel.setImg(inputStream);
        }


        hotelDOAImp.insert(hotel);

        goBackToAdminDash(event);
    }


    }

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
    private TextField hotelNameField;
    @FXML
    private TextField hotelChainField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField ratingField;
    @FXML
    private TextField pricePerNightField;
    @FXML
    private TextField availableRoomsField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextArea descriptionField;
    @FXML
    private DatePicker creatAtField;


    @FXML
    private void setVisibilityHotel() {
        dis_lab.setVisible(promotionCheckBox.isSelected());
        dur_lab.setVisible(promotionCheckBox.isSelected());
        dis_txt.setVisible(promotionCheckBox.isSelected());
        dur_txt.setVisible(promotionCheckBox.isSelected());

    }
    @FXML
    private ImageView img2;

    JFileChooser chooser = new JFileChooser();
    @FXML
    private void getImage2() {

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


}


