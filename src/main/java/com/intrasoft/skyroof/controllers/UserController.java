package com.intrasoft.skyroof.controllers;

import com.intrasoft.skyroof.entities.User;
import com.intrasoft.skyroof.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")//works
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")//works
    public User getUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users/{userName}")//works
    public List<User> getUserName(@PathVariable("userName") String userName) {
        return userService.findByUserName(userName);
    }

    @PostMapping("/user")//works
    public Long createUser(@Validated @RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/user/{id}")//works
    public void updateUser(@RequestBody User user, @PathVariable Long id) {
        userService.updateUser(user, id);
    }

    @DeleteMapping("/user/{id}")//works
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
