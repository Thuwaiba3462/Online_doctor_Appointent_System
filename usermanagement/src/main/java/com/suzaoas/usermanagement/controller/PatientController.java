package com.suzaoas.usermanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.suzaoas.usermanagement.model.Patient;
import com.suzaoas.usermanagement.repository.PatientRepository;

@CrossOrigin(origins ="*",allowedHeaders = "*")
@RestController
@RequestMapping("api/patient")
@Controller
public class PatientController {
  @Autowired  
  private PatientRepository patientRepository;

  @GetMapping(value = "/get")
  public List <Patient> getPatient(){
    return patientRepository.findAll();

    
  }

  @PostMapping(value = "/create")
  public String savePatient(@RequestBody Patient patient){
    patientRepository.save(patient);
     return "saved";
  }


@PutMapping(value = "/update/{P_id}")
public String updatePatient(@PathVariable long p_id, @RequestBody Patient updatedPatient) {
    Optional<Patient> patientOptional = patientRepository.findById(p_id);
    if (patientOptional.isPresent()) {
        Patient existingPatient = patientOptional.get();
        existingPatient.setName(updatedPatient.getName());
        existingPatient.setEmail(updatedPatient.getEmail());
        existingPatient.setContact(updatedPatient.getContact());
        existingPatient.setAddress(updatedPatient.getAddress());
        existingPatient.setPassword(updatedPatient.getPassword());
        patientRepository.save(existingPatient);
        return "Updated...";
    } else {
        return "Patient not found";
    }
}
@DeleteMapping(value = "/delete/{P_id}")
public String deletePatient(@PathVariable("p_id") Long p_id) {
    Optional<Patient> patientOptional = patientRepository.findById(p_id);
    if (patientOptional.isPresent()) {
        Patient patient = patientOptional.get();
        patientRepository.delete(patient);
        return "Deleted...";
    } else {
        return "Patient not found";
    }
}


@GetMapping(value = "/get/{P_id}")
public ResponseEntity<Patient> getPatient(@PathVariable("p_id") Long p_id) {
    Optional<Patient> patientOptional = patientRepository.findById(p_id);
    if (patientOptional.isPresent()) {
        Patient patient = patientOptional.get();
        return ResponseEntity.ok(patient);
    } else {
        return ResponseEntity.notFound().build();
    }
}

@GetMapping(value="list")
public List<Patient> getPatients(){
    return patientRepository.findAll();
}

}
