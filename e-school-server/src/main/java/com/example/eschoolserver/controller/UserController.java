package com.example.eschoolserver.controller;

import com.example.eschoolserver.model.User;
import com.example.eschoolserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

//    @PostMapping("/")
//    public ResponseEntity<?> loginUser(@RequestBody User userData){
//        User user = userService.getUserByUsername(userData.getUsername());
//        if(user.getPassword().equals(userData.getPassword()))
//            return ResponseEntity.ok(user);
//        return (ResponseEntity<User>) ResponseEntity.internalServerError();
//    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userData){
        User user = userService.getUserByUsername(userData.getUsername());
        if(user.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(user);
        return (ResponseEntity<User>) ResponseEntity.internalServerError();
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User userData) {
        User user = userService.getUserByUsername(userData.getUsername());
        if(user != null && !userData.getUsername().equals("") && !userData.getPassword().equals("")){
            userService.addUser(userData);
            return  userData;
        }
        return null;
    }
}
