package com.example.SpringBoot_5.Controller;

import com.example.SpringBoot_5.Entity.Customer;
import com.example.SpringBoot_5.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){

        String upsert = customerService.upsert(customer);
         return  new ResponseEntity<>(upsert, HttpStatus.CREATED);
    }

    @GetMapping("/cus/{cusId}")
    public  ResponseEntity<Customer> getById(@PathVariable Integer cusId){

        Customer byId = customerService.getById(cusId);
        return  new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<Customer>> getAlll(){
        List<Customer> get=customerService.getAll();
        return  new ResponseEntity<>(get,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateCus(@RequestBody Customer customer){

        String upsert = customerService.upsert(customer);
        return  new ResponseEntity<>(upsert, HttpStatus.OK);
    }

    @DeleteMapping("/cus/{cusId}")
    public  ResponseEntity<String> deleteById(@PathVariable Integer cusId){

        String byId = customerService.deleteById(cusId);
        return  new ResponseEntity<>(byId,HttpStatus.OK);
    }
}
