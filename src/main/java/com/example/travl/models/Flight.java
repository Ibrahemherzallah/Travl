package com.example.travl.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private int flight_id;

    @Column(name = "admin_id")
    private int admin_id;

    @Column(name = "flight_name")
    private String flight_name;

    @Column(name = "airline")
    private String airline;

    @Column(name = "price")
    private int price;

    @Column(name = "destination")
    private String destination;

    @Column(name = "date")
    private Date date;

    @Column(name = "duration")
    private String duration;

    @Column(name = "image")
    private String image;

    @Column(name = "number_of_passengers")
    private String number_of_passengers;

    @Column(name = "stops")
    private String stops;

    @Column(name = "promotion")
    private String promotion;

    @Column(name = "description")
    private String description;

    @Column(name = "discount")
    private String discount;

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getFlight_name() {
        return flight_name;
    }

    public void setFlight_name(String flight_name) {
        this.flight_name = flight_name;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNumber_of_passengers() {
        return number_of_passengers;
    }

    public void setNumber_of_passengers(String number_of_passengers) {
        this.number_of_passengers = number_of_passengers;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
