package com.example.travl.models.interfaces;

import com.example.travl.models.Flight;
import com.example.travl.models.Hotel;

import java.util.List;

public interface FlightDOA {
    public void insert(Flight flight);
    public void update(Flight flight);
    public void delete(Flight flight);
    public List<Flight> getAll();
    public Flight findAdmin(int id);
    public Flight getFlightlByID(int ID);
}
