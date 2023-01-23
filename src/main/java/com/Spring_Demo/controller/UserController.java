package com.Spring_Demo.controller;

import com.Spring_Demo.entity.User;
import com.Spring_Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
   @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.saveUser(user));
    }

   @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUSer(){
       return ResponseEntity.ok().body(this.userService.getAllUser());
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable String id){
       return ResponseEntity.ok().body(this.userService.getSingleUser(id));
    }

    @GetMapping("/admin")
    public String Admin(){
       return "this is Admin page";
    }

    @GetMapping("/normal")
    public String Normal(){
       return "this is Normal page";
    }
}
