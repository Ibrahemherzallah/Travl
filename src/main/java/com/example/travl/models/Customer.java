package com.example.travl.models;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "num_of_kids")
    private int num_of_kids;

    @Column(name = "num_of_adults")
    private int num_of_adults;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNum_of_adults() {
        return num_of_adults;
    }

    public void setNum_of_adults(int num_of_adults) {
        this.num_of_adults = num_of_adults;
    }

    public int getNum_of_kids() {
        return num_of_kids;
    }

    public void setNum_of_kids(int num_of_kids) {
        this.num_of_kids = num_of_kids;
    }
}
