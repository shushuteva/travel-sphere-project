package com.travelsphere.travelsphere.repository;

import com.travelsphere.travelsphere.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepo extends JpaRepository<Payments, Integer> {
}
