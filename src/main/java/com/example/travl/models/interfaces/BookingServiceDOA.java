package com.example.travl.models.interfaces;

import com.example.travl.models.BookingService;
import com.example.travl.models.Customer;

import java.util.List;

public interface BookingServiceDOA {
    public void insert(BookingService bookingService);
    public void update(BookingService bookingService);
    public void delete(BookingService bookingService);
    public List<Customer> getAll();
}
