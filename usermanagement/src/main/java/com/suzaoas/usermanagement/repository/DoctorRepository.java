package com.suzaoas.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suzaoas.usermanagement.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    
}
