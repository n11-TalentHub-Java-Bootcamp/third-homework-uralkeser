package com.uralkeser.controller;

import com.uralkeser.entity.User;
import com.uralkeser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody User category) {

        category = userService.save(category);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteById(id);
    }
}
