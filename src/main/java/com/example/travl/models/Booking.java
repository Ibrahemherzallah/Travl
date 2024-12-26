package com.example.travl.models;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "booking_type")
    private BOOKING_TYPE bookingType;

    @Column(name = "type_id")
    private int typeId;
}

