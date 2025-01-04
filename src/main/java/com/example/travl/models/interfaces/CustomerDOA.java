package com.example.travl.models.interfaces;

import com.example.travl.models.Customer;
import java.util.List;

public interface CustomerDOA {
        public void insert(Customer customer);
        public void update(Customer customer);
        public void delete(Customer customer);
        public List<Customer> getAll();
        public Customer findAdmin(int id);
}
