package com.suzaoas.usermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suzaoas.usermanagement.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Long> {

    public default Feedback save(Feedback feedback) {
        return null;
    }

    public default Optional<Feedback> findById(Long id) {
        return null;
    }

    public default void delete(Feedback feedback) {
    }
    
}
