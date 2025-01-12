package com.travelsphere.travelsphere.repository;

import com.travelsphere.travelsphere.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);
}
