package com.codegym.thuchanh2.model.service;

import com.codegym.thuchanh2.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findCustomer(int id);
    void update(int id, String name, String email, String address);
}
