package com.example.travl.models;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_name")
    private String customerName;

    public BOOK_TYPE getBookType() {
        return bookType;
    }

    public void setBookType(BOOK_TYPE bookType) {
        this.bookType = bookType;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerNumOfKids() {
        return customerNumOfKids;
    }

    public void setCustomerNumOfKids(String customerNumOfKids) {
        this.customerNumOfKids = customerNumOfKids;
    }

    public String getCustomerNumOfAdults() {
        return customerNumOfAdults;
    }

    public void setCustomerNumOfAdults(String customerNumOfAdults) {
        this.customerNumOfAdults = customerNumOfAdults;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Column(name = "customer_num_of_adults")
    private String customerNumOfAdults;

    @Column(name = "customer_num_of_kids")
    private String customerNumOfKids;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "book_type")
    private BOOK_TYPE bookType;

}
enum BOOK_TYPE {
    FLIGHT,HOTEL
}