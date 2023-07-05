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

import com.suzaoas.usermanagement.model.Doctor;
import com.suzaoas.usermanagement.repository.DoctorRepository;

@CrossOrigin(origins ="*",allowedHeaders = "*")
@RestController
@RequestMapping("api/doctor/")
@Controller
public class DoctorController {
  @Autowired  
   private DoctorRepository doctorRepository;

@GetMapping(value = "/get")
public List<Doctor> getDoctor(){
 return doctorRepository.findAll();
}
   

   @PostMapping (value="/create")
   public String saveDoctor(@RequestBody Doctor doctor){
    doctorRepository.save(doctor);
    return "saved....";
   }


   @PutMapping(value = "/update/{D_id}")
public String updateDoctor(@PathVariable Long d_id, @RequestBody Doctor updatedDoctor) {
    Optional<Doctor> doctorOptional = doctorRepository.findById(d_id);
    if (doctorOptional.isPresent()) {
        Doctor existingDoctor = doctorOptional.get();
        existingDoctor.setName(updatedDoctor.getName());
        existingDoctor.setCategory(updatedDoctor.getCategory());
        existingDoctor.setContact(updatedDoctor.getContact());
        existingDoctor.setAddress(updatedDoctor.getAddress());
        existingDoctor.setPassword(updatedDoctor.getPassword());
        existingDoctor.setEmail(updatedDoctor.getEmail());
        doctorRepository.save(existingDoctor);
        return "Updated...";
    } else {
        return "Doctor not found";
    }
}

  @DeleteMapping(value = "/delete/{d_id}")
public String deleteDoctor(@PathVariable("d_id") Long d_id) {
    Optional<Doctor> doctorOptional = doctorRepository.findById(d_id);
    if (doctorOptional.isPresent()) {
        Doctor doctor = doctorOptional.get();
        doctorRepository.delete(doctor);
        return "Deleted...";
    } else {
        return "Doctor not found";
    }    
}
 



@GetMapping(value = "/get/{D_id}")
public ResponseEntity<Doctor> getDoctor(@PathVariable("d_id") Long d_id) {
    Optional<Doctor> doctorOptional = doctorRepository.findById(d_id);
    if (doctorOptional.isPresent()) {
        Doctor doctor = doctorOptional.get();
        return ResponseEntity.ok(doctor);
    } else {
        return ResponseEntity.notFound().build();
    }
}


 
}
