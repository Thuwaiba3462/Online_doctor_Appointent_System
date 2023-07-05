package com.suzaoas.usermanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="feedback")
    private String feedback;


     @ManyToOne
    @JoinColumn(name = "p_id")
    private Patient p_id;


    public Object getFeedback() {
        return null;
    }


    public void setFeedback(Object feedback2) {
    }


}

