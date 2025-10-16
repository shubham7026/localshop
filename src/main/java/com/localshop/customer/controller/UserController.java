package com.localshop.customer.controller;

import com.localshop.customer.model.User;
import com.localshop.customer.services.implementations.PropertyEditor;
import com.localshop.customer.services.interfaces.IUserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final IUserApplicationService userApplicationService;

//    @InitBinder
//    public void dataBinder(DataBinder dataBinder){
//        dataBinder.registerCustomEditor(String.class, "mobileNo", new PropertyEditor());
//    }

//    @GetMapping("/login")
//    public ResponseEntity<User> login(@RequestBody User user) {
//
//        userApplicationService.login(user);
//        return ResponseEntity
//                .status(HttpStatus.ACCEPTED)
//                .build();
//    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam("mobileNo") String mobileNo,
                                      @RequestParam("password") String password) {

        userApplicationService.login(mobileNo,password);
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
