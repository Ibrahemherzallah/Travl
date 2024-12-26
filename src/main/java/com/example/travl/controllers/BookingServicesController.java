package com.example.travl.controllers;

import com.example.travl.models.BOOKING_TYPE;
import com.example.travl.models.User;


public class BookingServicesController {

    private int id;
    private BOOKING_TYPE bookingType;
    private int typeId;
    private User user;

    public void Book(){}
    public boolean userHasPermission(){
        return true;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public BOOKING_TYPE getBookingType() {
        return bookingType;
    }

    public void setBookingType(BOOKING_TYPE bookingType) {
        this.bookingType = bookingType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
