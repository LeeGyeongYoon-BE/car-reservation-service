package com.example.gyeongyoonfinalproject.controller;

import com.example.gyeongyoonfinalproject.entity.User;
import com.example.gyeongyoonfinalproject.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.gyeongyoonfinalproject.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestParam String name, @RequestParam String email) {
        try {
            return userService.addUser(name, email);
        } catch (BadRequestException ex) {
            throw ex;
        }
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/update")
    public User updateUser(@RequestParam long id, @RequestParam String name, @RequestParam String email) {
        return userService.updateUser(id, name, email);
    }
}
