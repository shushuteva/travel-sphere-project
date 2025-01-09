package com.travelsphere.travelsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelsphere.travelsphere.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    public Customer findByEmail(String email);

}