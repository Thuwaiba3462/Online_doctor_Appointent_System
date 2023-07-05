package com.suzaoas.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suzaoas.usermanagement.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}