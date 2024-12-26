package com.example.travl.models.interfaces;

import com.example.travl.models.Role;

import java.util.List;

public interface RoleDOA {
    public void insert(Role role);
    public void update(Role role);
    public void delete(Role role);
    public List<Role> getAll();
    public Role findRole(int id);
}
