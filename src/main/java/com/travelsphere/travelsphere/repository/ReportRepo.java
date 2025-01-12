package com.travelsphere.travelsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.travelsphere.travelsphere.model.Report;

public interface ReportRepo extends JpaRepository<Report, Integer> {
}
