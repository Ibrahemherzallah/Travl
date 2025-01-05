package com.example.travl.models.interfaces;

import com.example.travl.models.BookingService;
import java.util.List;

public interface BookingServiceDOA {
    BookingService findBooking(String bookingID);

}