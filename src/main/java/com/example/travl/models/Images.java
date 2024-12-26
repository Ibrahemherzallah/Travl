package com.example.travl.models;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Images {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "url")
    private String url;
}