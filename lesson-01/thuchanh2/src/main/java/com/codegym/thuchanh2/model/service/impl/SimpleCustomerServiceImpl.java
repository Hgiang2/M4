package com.codegym.thuchanh2.model.service.impl;

import com.codegym.thuchanh2.model.entity.Customer;
import com.codegym.thuchanh2.model.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SimpleCustomerServiceImpl implements CustomerService {
    private List<Customer> customerList;
    private static CustomerService instance;
    private SimpleCustomerServiceImpl() {
        updateCustomerList();
    }
    private void updateCustomerList() {
        if (customerList == null) {
            customerList = new ArrayList<>();
            Customer customer1 = new Customer(1, "Nguyen Van A", "anguyen@gmail.com", "Ha Noi");
            Customer customer2 = new Customer(2, "Tran Thi B", "btran@gmail.com", "Ho Chi Minh");
            Customer customer3 = new Customer(3, "Phan C", "cphan@gmail.com", "Ha Tay");
            Customer customer4 = new Customer(4, "Nguyen Thi D", "dnguyen@gmail.com", "Ha Giang");
            Customer customer5 = new Customer(5, "Hoang Minh E", "ehoang@gmail.com", "Soc Trang");
            customerList.add(customer1);
            customerList.add(customer2);
            customerList.add(customer3);
            customerList.add(customer4);
            customerList.add(customer5);
        }
    }
    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new SimpleCustomerServiceImpl();
        }
        return instance;
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findCustomer(int id) {
        Customer currentCustomer = null;
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                currentCustomer = customer;
                break;
            }
        }
        return currentCustomer;
    }

    @Override
    public void update(int id, String name, String email, String address) {
        Customer currentCustomer = findCustomer(id);
        currentCustomer.setName(name);
        currentCustomer.setEmail(email);
        currentCustomer.setAddress(address);
    }
}
