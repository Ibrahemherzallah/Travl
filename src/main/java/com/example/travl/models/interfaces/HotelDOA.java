package com.example.travl.models.interfaces;

import com.example.travl.models.Hotel;

import java.util.List;

public interface HotelDOA {
    public void insert(Hotel hotel);
    public void update(Hotel hotel);
    public void delete(Hotel hotel);
    public List<Hotel> getAll();
    public Hotel findAdmin(int id);
}
