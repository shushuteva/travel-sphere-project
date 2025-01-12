package com.travelsphere.travelsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelsphere.travelsphere.model.Package;

@Repository
public interface PackageRepo extends JpaRepository<Package, Integer> {
}
