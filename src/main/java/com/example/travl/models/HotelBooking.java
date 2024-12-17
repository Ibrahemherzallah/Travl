package com.example.travl.models;

import javax.persistence.*;

@Entity
@Table(name = "hotel_booking")
public class HotelBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int book_id;

    @Column(name = "hotel_id")
    private int hotel_id;

    @Column(name = "agent_id")
    private int agent_id;

    @Column(name = "status")
    private String status;

    @Column(name = "check_in")
    private String check_in;

    @Column(name = "check_out")
    private String check_out;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "customer_address")
    private String customer_address;

    @Column(name = "customer_email")
    private String customer_email;

    @Column(name = "customer_phone")
    private String customer_phone;

    @Column(name = "customer_name")
    private String customer_name;

    @Column(name = "payment_method")
    private String payment_method;

    @Column(name = "customer_num_of_adults")
    private String customer_num_of_adults;

    @Column(name = "customer_num_of_kids")
    private String customer_num_of_kids;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
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

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getCustomer_num_of_adults() {
        return customer_num_of_adults;
    }

    public void setCustomer_num_of_adults(String customer_num_of_adults) {
        this.customer_num_of_adults = customer_num_of_adults;
    }

    public String getCustomer_num_of_kids() {
        return customer_num_of_kids;
    }

    public void setCustomer_num_of_kids(String customer_num_of_kids) {
        this.customer_num_of_kids = customer_num_of_kids;
    }
}

