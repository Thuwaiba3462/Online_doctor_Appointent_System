package com.suzaoas.usermanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Patient") 
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;
    @Column(name="name")
    private String name;

    @Column(name="email")
    private String Email;

    @Column(name="contact")
    private int contact;

    @Column(name="address")
    private String address;


   
     @Column(name="password")
    private String password;

    
     @Column(name="bloodtype")
    private String bloodtype;


    public Long getP_id() {
        return p_id;
    }


    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return Email;
    }


    public void setEmail(String email) {
        Email = email;
    }


    public int getContact() {
        return contact;
    }


    public void setContact(int contact) {
        this.contact = contact;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getBloodtype() {
        return bloodtype;
    }


    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }



}
