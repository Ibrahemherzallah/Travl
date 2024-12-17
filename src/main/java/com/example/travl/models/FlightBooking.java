package com.example.travl.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="flight_booking")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int book_id;

    @Column(name = "flight_id")
    private int flight_id;

    @Column(name = "agent_id")
    private int agent_id;

    @Column(name = "status")
    private String status;

    @Column(name = "airline")
    private String airline;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departure_time")
    private String departure_time;

    @Column(name = "arrival_time")
    private String arrival_time;

    @Column(name = "price")
    private String price;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "customer_name")
    private String customer_name;

    @Column(name = "customer_address")
    private String customer_address;

    @Column(name = "customer_email")
    private String customer_email;

    @Column(name = "customer_phone")
    private String customer_phone;

    @Column(name = "customer_num_of_adults")
    private int customer_num_of_adults;

    @Column(name = "customer_num_of_kids")
    private int customer_num_of_kids;

    @Column(name = "payment_method")
    private String payment_method;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public int getCustomer_num_of_adults() {
        return customer_num_of_adults;
    }

    public void setCustomer_num_of_adults(int customer_num_of_adults) {
        this.customer_num_of_adults = customer_num_of_adults;
    }

    public int getCustomer_num_of_kids() {
        return customer_num_of_kids;
    }

    public void setCustomer_num_of_kids(int customer_num_of_kids) {
        this.customer_num_of_kids = customer_num_of_kids;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
}


