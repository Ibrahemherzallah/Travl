package com.example.travl.models;


import javax.persistence.*;

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
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;


    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;


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
