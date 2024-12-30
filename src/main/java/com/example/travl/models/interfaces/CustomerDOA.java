package com.example.travl.models.interfaces;

import com.example.travl.models.Flight;

import java.util.List;

public interface CustomerDOA {
        public void insert(Flight flight);
        public void update(Flight flight);
        public void delete(Flight flight);
        public List<Flight> getAll();
        public Flight findAdmin(int id);
}
