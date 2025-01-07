package com.example.travl.models.interfaces;

import com.example.travl.models.User;

import java.util.List;

public interface UserDOA {
    public void insert(User User);
    public void update(User User);
    public void delete(User User);
    public List<User> getAll();
    public User findUser(int id);

    User findByEmailAndPassword(String email, String password);
}
