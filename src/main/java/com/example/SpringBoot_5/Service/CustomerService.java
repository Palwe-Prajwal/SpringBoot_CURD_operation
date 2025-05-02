package com.example.SpringBoot_5.Service;

import com.example.SpringBoot_5.Entity.Customer;

import java.util.List;

public interface CustomerService {

    public  String upsert(Customer customer);

    public  Customer getById(Integer cusId);

    public List<Customer> getAll();

    public String deleteById(Integer cusId);
}
