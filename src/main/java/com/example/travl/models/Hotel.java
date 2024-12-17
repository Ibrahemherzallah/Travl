package com.example.travl.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private int hotel_id;

    @Column(name = "admin_id")
    private int admin_id;

    @Column(name = "location")
    private String location;

    @Column(name = "rating")
    private int rating;

    @Column(name = "price_per_night")
    private int price_per_night;

    @Column(name = "created_at")
    private int created_at;

    @Column(name = "img")
    private int img;

    @Column(name = "promotion")
    private String promotion;

    @Column(name = "description_with_amenities")
    private String description_with_amenities;

    @Column(name = "discount_percent")
    private String discount_percent;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "hotel_name")
    private String hotel_name;

    @Column(name = "available_rooms")
    private int available_rooms;

    @Column(name = "hotel_chain")
    private String hotel_chain;

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice_per_night() {
        return price_per_night;
    }

    public void setPrice_per_night(int price_per_night) {
        this.price_per_night = price_per_night;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getDescription_with_amenities() {
        return description_with_amenities;
    }

    public void setDescription_with_amenities(String description_with_amenities) {
        this.description_with_amenities = description_with_amenities;
    }

    public String getDiscount_percent() {
        return discount_percent;
    }

    public void setDiscount_percent(String discount_percent) {
        this.discount_percent = discount_percent;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public int getAvailable_rooms() {
        return available_rooms;
    }

    public void setAvailable_rooms(int available_rooms) {
        this.available_rooms = available_rooms;
    }

    public String getHotel_chain() {
        return hotel_chain;
    }

    public void setHotel_chain(String hotel_chain) {
        this.hotel_chain = hotel_chain;
    }
}
