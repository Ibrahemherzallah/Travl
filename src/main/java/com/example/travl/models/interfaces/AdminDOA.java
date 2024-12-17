package com.example.travl.models.interfaces;

import com.example.travl.models.Admin;

import java.util.List;

public interface AdminDOA {
    public void insert(Admin admin);
    public void update(Admin admin);
    public void delete(Admin admin);
    public List<Admin> getAll();
    public Admin findAdmin(int id);
}
