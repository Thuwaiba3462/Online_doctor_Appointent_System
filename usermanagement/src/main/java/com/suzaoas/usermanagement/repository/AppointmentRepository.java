package com.suzaoas.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suzaoas.usermanagement.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    
}
