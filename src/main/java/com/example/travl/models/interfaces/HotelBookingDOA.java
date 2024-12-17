package com.example.travl.models.interfaces;

import com.example.travl.models.HotelBooking;

import java.util.List;

public interface HotelBookingDOA {
    public void insert(HotelBooking hotelBooking);
    public void update(HotelBooking hotelBooking);
    public void delete(HotelBooking hotelBooking);
    public List<HotelBooking> getAll();
    public HotelBooking findAdmin(int id);
}
