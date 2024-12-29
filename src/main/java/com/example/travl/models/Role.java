package com.example.travl.models;

import com.example.travl.controllers.PermissionController;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String value;

    @Column(name = "permission")
    private String permission;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    @oneToMany
//    @Column(name = "")
//    List<PermissionController>
}
