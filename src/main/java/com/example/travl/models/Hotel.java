package com.example.travl.models;

import javax.persistence.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "location")
    private String location;

    @Column(name = "num_of_star")
    private int numOfStar;

    @Column(name = "hotel_chain")
    private String hotelChain;

    @Column(name = "available_rooms")
    private int availableRooms;

    @Column(name = "description_with_amenities")
    private String descriptionWithAmenities;

    @Column(name = "phone")
    private String phone;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "promotion")
    private boolean promotion;

    @Column(name = "discount")
    private String discount;

    @Column(name = "promotion_duration")
    private int promotionDuration;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingService> bookingServices;
    @Column(name = "price_per_night")
    private double pricePerNight;


    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_id")
    private int imageId;

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }


    public List<BookingService> getBookingServices() {
        return bookingServices;
    }

    public void setBookingServices(List<BookingService> bookingServices) {
        this.bookingServices = bookingServices;
    public void setImg(InputStream inputStream) throws IOException {
        this.img = inputStream.readAllBytes();
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumOfStar() {
        return numOfStar;
    }

    public void setNumOfStar(int numOfStar) {
        this.numOfStar = numOfStar;
    }

    public String getHotelChain() {
        return hotelChain;
    }

    public void setHotelChain(String hotelChain) {
        this.hotelChain = hotelChain;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public String getDescriptionWithAmenities() {
        return descriptionWithAmenities;
    }

    public void setDescriptionWithAmenities(String descriptionWithAmenities) {
        this.descriptionWithAmenities = descriptionWithAmenities;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public int getPromotionDuration() {
        return promotionDuration;
    }

    public void setPromotionDuration(int promotionDuration) {
        this.promotionDuration = promotionDuration;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void addHotel(){}
    public void deleteHotel(){}
    public void editHotel(){}
    public Hotel getHotel(){return this;}
    public void getUser(){}
    public void deleteUser(int id){}



    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setImg(FileInputStream inputSteam) {
    }
}
