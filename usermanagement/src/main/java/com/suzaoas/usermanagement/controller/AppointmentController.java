package com.suzaoas.usermanagement.controller;
import java.util.Optional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suzaoas.usermanagement.model.Appointment;
import com.suzaoas.usermanagement.repository.AppointmentRepository;

@CrossOrigin(origins ="*",allowedHeaders = "*")
@RestController
@RequestMapping("api/appointment")
public class AppointmentController {
  @Autowired  AppointmentRepository appointmentRepository;
  
  
  @GetMapping(value = "/get/{A_id}")
public ResponseEntity<Appointment> getAppointment(@PathVariable("a_id") long a_id) {
    Optional<Appointment> appointmentOptional = appointmentRepository.findById(a_id);
    if (appointmentOptional.isPresent()) {
        Appointment appointment = appointmentOptional.get();
        return ResponseEntity.ok(appointment);
    } else {
        return ResponseEntity.notFound().build();
    }
}


@PostMapping(value = "/create")
public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
    Appointment createdAppointment = appointmentRepository.save(appointment);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
}


@PutMapping(value = "/update/{A_id}")
public ResponseEntity<String> updateAppointment(@PathVariable("a_id") long a_id, @RequestBody Appointment updatedAppointment) {
    Optional<Appointment> appointmentOptional = appointmentRepository.findById(a_id);
    if (appointmentOptional.isPresent()) {
        Appointment existingAppointment = appointmentOptional.get();
        
        
        // Update the patient and doctor information if needed
        existingAppointment.setPatient(updatedAppointment.getPatient());
        existingAppointment.setDoctor(updatedAppointment.getDoctor());
        
        appointmentRepository.save(existingAppointment);
        return ResponseEntity.ok("Updated...");
    } else {
        return ResponseEntity.notFound().build();
    }
}


@DeleteMapping(value = "/delete/{A_id}")
public ResponseEntity<String> deleteAppointment(@PathVariable("a_id") long a_id) {
    Optional<Appointment> appointmentOptional = appointmentRepository.findById(a_id);
    if (appointmentOptional.isPresent()) {
        Appointment appointment = appointmentOptional.get();
        appointmentRepository.delete(appointment);
        return ResponseEntity.ok("Deleted...");
    } else {
        return ResponseEntity.notFound().build();
    }
}
@GetMapping(value="list")
public List<Appointment> getAppointment(){
    return appointmentRepository.findAll();
}


@GetMapping("/alllist")
public ResponseEntity<?> getAll(){
    try{
        List<Appointment> list = appointmentRepository.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>("No data found", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }catch(Exception exception){
        return new ResponseEntity<>("Network Error", HttpStatus.BAD_GATEWAY);
    }
}

}

