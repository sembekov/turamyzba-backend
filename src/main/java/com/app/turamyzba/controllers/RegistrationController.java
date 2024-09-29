package com.app.turamyzba.controllers;

import com.app.turamyzba.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.app.turamyzba.services.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    private UserServiceImpl service;

    @GetMapping("/welcome")
    public String welcome(){
        return "Page for non authorized people";
    }
    @GetMapping("/users")
    @PreAuthorize("hasAuthority('USER')")
    public List<User> allUsers(){
        return service.getAllUsers();
    }
    @GetMapping("/users/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<User> userById(@PathVariable long id){
        return service.getUser(id);
    }
    @PostMapping("/new-user")
    public String addUser(@RequestBody User user){
        service.saveUser(user);
        return "User is saved";
    }
}
