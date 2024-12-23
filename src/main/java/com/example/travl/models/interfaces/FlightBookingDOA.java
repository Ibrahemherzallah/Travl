package com.example.travl.models.interfaces;

import com.example.travl.models.FlightBooking;

import java.util.List;

public interface FlightBookingDOA {
    public void insert(FlightBooking flightBooking);
    public void update(FlightBooking flightBooking);
    public void delete(FlightBooking flightBooking);
    public List<FlightBooking> getAll();
    public FlightBooking findAdmin(int id);
}
