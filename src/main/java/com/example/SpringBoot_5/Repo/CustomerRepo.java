package com.example.SpringBoot_5.Repo;

import com.example.SpringBoot_5.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer ,Integer> {
}
