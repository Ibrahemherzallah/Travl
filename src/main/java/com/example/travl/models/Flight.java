package com.example.travl.models;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "flight_name")
    private String flightName;

    @Column(name = "airline")
    private String airline;

    @Column(name = "ticket_price")
    private int ticketPrice;

    @Column(name = "departure_date")
    private Date DepartureDate;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "stops")
    private String stops;

    @Column(name = "destination")
    private String destination;

    @Column(name = "duration")
    private String duration;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "number_of_passengers")
    private int numberOfPassengers;

    @Column(name = "promotion")
    private boolean promotion;

    @Column(name = "discount")
    private String discount;

    @Column(name = "promotion_duration")
    private int promotionDuration;

//    @Column(name = "available_flight")
//    private int availableFlight;


    @Column(name = "des_from")
    private String des_from;


    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingService> bookingServices;

    @Lob
    @Column(name = "image")
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getPromotionDuration() {
        return promotionDuration;
    }
    public String getFrom() {
        return des_from;
    }

    public void setFrom(String from) {
        this.des_from = from;
    }
    public void setPromotionDuration(int promotionDuration) {
        this.promotionDuration = promotionDuration;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(Date departureDate) {
        DepartureDate = departureDate;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
