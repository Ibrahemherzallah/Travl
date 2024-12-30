package com.example.travl.controllers;
import com.example.travl.models.User;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class FlightController {

    private int id;
    private String flightName;
    private String airline;
    private int ticketPrice;
    private Date DepartureDate;
    private Date arrivalDate;
    private String stops;
    private String destination;
    private String duration;
    private Date createdAt;
    private int numberOfPassengers;
    private boolean promotion;
    private String discount;
    private int promotionDuration;
    private UserController userController;

    public void addFlight(){}
    public void deleteFlight(){}
    public void editFlight(){}
    public FlightController getFlight(int id){
        return null;
    }

    public void addUser(){}
    public List<User> getUsers(){
        return null;
    }
    public void deleteUser(int id){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPromotionDuration() {
        return promotionDuration;
    }

    public void setPromotionDuration(int promotionDuration) {
        this.promotionDuration = promotionDuration;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(Date departureDate) {
        DepartureDate = departureDate;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }
}
