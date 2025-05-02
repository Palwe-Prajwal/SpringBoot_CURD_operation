package com.example.SpringBoot_5.Service;

import com.example.SpringBoot_5.Entity.Customer;
import com.example.SpringBoot_5.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public String upsert(Customer customer) {
        customerRepo.save(customer);

        return "Success..";
    }

    @Override
    public Customer getById(Integer cusId) {

        Optional<Customer> byId = customerRepo.findById(cusId);

        if (byId.isPresent()){
            customerRepo.findById(cusId);
            return byId.get();
        }
        return null;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> all = customerRepo.findAll();
        return all;
    }

    @Override
    public String deleteById(Integer cusId) {
        if (customerRepo.existsById(cusId)){
            customerRepo.deleteById(cusId);
            return "Delete Id";
        }
        return "Record not found";
    }
}
