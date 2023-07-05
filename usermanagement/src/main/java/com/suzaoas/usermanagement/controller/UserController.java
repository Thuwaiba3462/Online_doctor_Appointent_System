package com.suzaoas.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suzaoas.usermanagement.model.User;
import com.suzaoas.usermanagement.services.UserServices;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserServices userservices;
    /*
     * private UserRepository userRepository;
     * 
     * @PostMapping()
     * public void addUser(@RequestBody User users) {
     * userRepository.save(users);
     * }
     */

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User users) {
        User savedUser = userservices.createUser(users);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userlist = userservices.getAllUsers();
        return new ResponseEntity<>(userlist, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User userlist = userservices.getUserbyId(userId);
        return new ResponseEntity<>(userlist, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long userId) {
        userservices.delete(userId);
        return new ResponseEntity<String>("Successfully deleted ", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long userId, @RequestBody User users) {
        users.setId(userId);
        User userupdate = userservices.updateUser(users);
        return new ResponseEntity<>(userupdate, HttpStatus.OK);
    }

}
