package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.UserRole;
import com.example.Ecommerce.Service.UserService;
import com.example.Ecommerce.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("api/v1/allUsers")
//    List<User> getAllUser(){
//        return userService.getAllUsers();
//    }

    @GetMapping("api/v1/allUsers")
    ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.getAllUsers());
    }

    @PostMapping("api/v1/addUser")
    User addUser(@RequestBody User aUser){
        return userService.addUser(aUser);
    }

    @PostMapping("api/v1/assignRole")
    void assignRoleToUser(@ModelAttribute  UserRole userRole){
        userService.assignRoleToUser(userRole);
    }
}
