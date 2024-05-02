package com.rossbach.controller;

import com.rossbach.entities.User;
import com.rossbach.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes =  APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody User user) {
        this.userService.createUser(user);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<User> showUsers() {
        return this.userService.showUsers();
    }



}
