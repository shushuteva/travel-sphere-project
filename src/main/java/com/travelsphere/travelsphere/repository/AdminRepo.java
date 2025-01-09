package com.travelsphere.travelsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelsphere.travelsphere.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

    public Admin findByEmail(String email);

}
