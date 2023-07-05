package com.suzaoas.usermanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suzaoas.usermanagement.model.User;
import com.suzaoas.usermanagement.repository.UserRepository;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User users) {
        return userRepository.save(users);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserbyId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(User users) {
        User extinguser = userRepository.findById(users.getId()).get();
        extinguser.setFirstName(users.getFirstName());
        extinguser.setLastName(users.getLastName());
        extinguser.setEmail(users.getEmail());
        return userRepository.save(extinguser);
    }

}
