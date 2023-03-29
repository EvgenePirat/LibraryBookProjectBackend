package com.example.backend.Booksbackend.controller;

import com.example.backend.Booksbackend.entity.User;
import com.example.backend.Booksbackend.repository.UserRepository;
import com.example.backend.Booksbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/account")
@CrossOrigin("http://localhost:3000/")
public class ControllerAccount {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/save_user")
    public ResponseEntity saveNewUser(@RequestBody User user){
        return userService.checkUserForRegistration(user) == false ? new ResponseEntity(HttpStatus.CONFLICT) : new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/check_data")
    public ResponseEntity enterToSystem(@RequestBody User user){
        return userService.checkUserInEnterToSystem(user) == true ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.CONFLICT) ;
    }

    @PostMapping("/get")
    public @ResponseBody User getUserFromDb(@RequestBody User user){
        return userRepository.findByLogin(user.getLogin());
    }

}
