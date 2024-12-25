package com.example.travl.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "admin_name")
    private String admin_name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private int password;

    @Column(name = "img")
    private String img;

    @Column(name = "num_of_agent")
    private int num_of_agent;






    public int getNum_of_agent() {
        return num_of_agent;
    }

    public void setNum_of_agent(int num_of_agent) {
        this.num_of_agent = num_of_agent;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
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

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public int getAdmin_id() {
        return id;
    }

    public void setAdmin_id(int admin_id) {
        this.id = admin_id;
    }


}
