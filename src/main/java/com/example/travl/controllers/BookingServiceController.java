package com.example.travl.controllers;

import com.example.travl.models.*;

public class BookingServiceController {
    private int id;
    private String bookingType;
    private Hotel hotel;
    private Flight flight;
    private UserController user;
    private Customer customer;

    public void book(){}
    public boolean userHasPermission(Permission permission){
        return this.user.userHasPermission(permission);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public UserController getUser() {
        return this.user;
    }

    public void setUser(User user) {
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
