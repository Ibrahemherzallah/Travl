package com.example.travl.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking_services")
public class BookingService {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "booking_type")
    private String booking_type;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_at")
    private Date created_at;


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

    public String getBooking_type() {
        return booking_type;
    }

    public void setBooking_type(String booking_type) {
        this.booking_type = booking_type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
