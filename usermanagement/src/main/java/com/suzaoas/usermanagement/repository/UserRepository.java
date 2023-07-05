package com.suzaoas.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suzaoas.usermanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
