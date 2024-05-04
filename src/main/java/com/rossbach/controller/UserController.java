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

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") int id) {
        User showUser = this.userService.showUserById(id);
        if (showUser == null){
            throw new RuntimeException("Cet user n'existe pas");
        }
        else {
            this.userService.deleteUser(id);
        }

    };

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<User> showUsers() {
        return this.userService.showUsers();
    }



}
