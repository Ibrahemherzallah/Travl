package com.example.travl.controllers;

import com.example.travl.models.User;

import java.awt.*;
import java.util.Date;
import java.util.List;

public class HotelController {

    private int id;
    private String hotelName;
    private String location;
    private int numOfStar;
    private String hotelChain;
    private int availableRooms;
    private String descriptionWithAmenities;
    private String phone;
    private Date created_at;
    private boolean promotion;
    private String discount;
    private int promotionDuration;
    private List<User> users;


    public void addHotel(){}
    public void deleteHotel(){}
    public void editHotel(){}
    public FlightController getHotel(int id){
        return null;
    }

    public void addUser(){}
    public void deleteUser(int id){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumOfStar() {
        return numOfStar;
    }

    public void setNumOfStar(int numOfStar) {
        this.numOfStar = numOfStar;
    }

    public String getHotelChain() {
        return hotelChain;
    }

    public void setHotelChain(String hotelChain) {
        this.hotelChain = hotelChain;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public String getDescriptionWithAmenities() {
        return descriptionWithAmenities;
    }

    public void setDescriptionWithAmenities(String descriptionWithAmenities) {
        this.descriptionWithAmenities = descriptionWithAmenities;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getPromotionDuration() {
        return promotionDuration;
    }

    public void setPromotionDuration(int promotionDuration) {
        this.promotionDuration = promotionDuration;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
