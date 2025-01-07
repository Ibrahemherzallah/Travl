package com.example.travl.controllers;

import com.example.travl.models.Hotel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;

public class HotelDetailsController {

    @FXML
    private Label hotelNameLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label checkInLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private ImageView hotelImageView;

    private Hotel selectedHotel;

    public void setSelectedHotel(Hotel hotel) {
        this.selectedHotel = hotel;
        if (hotel != null) {
            hotelNameLabel.setText(hotel.getHotelName() != null ? hotel.getHotelName() : "No Name Available");
            locationLabel.setText(hotel.getLocation() != null ? hotel.getLocation() : "No Location Available");
            checkInLabel.setText(hotel.getCreated_at() != null ? hotel.getCreated_at().toString() : "No Date Available");
            priceLabel.setText(hotel.getPricePerNight() != null ? "$" + hotel.getPricePerNight() : "Price Unavailable");
            if (hotel.getImg() != null) {
                Image image = new Image(new ByteArrayInputStream(hotel.getImg()));
                hotelImageView.setImage(image);
            }
        }
    }
}
