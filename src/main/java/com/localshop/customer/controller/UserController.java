package com.localshop.customer.controller;

import com.localshop.customer.model.User;
import com.localshop.customer.services.interfaces.IUserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final IUserApplicationService userApplicationService;

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {

        userApplicationService.login(user);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }

    @PostMapping("/signup")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createduser = userApplicationService.addUser(user);
        return ResponseEntity
                .status(202)
                .body(createduser);
    }
}
