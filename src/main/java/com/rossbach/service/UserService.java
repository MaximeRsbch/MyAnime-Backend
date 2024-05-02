package com.rossbach.service;

import com.rossbach.UserRepository;
import com.rossbach.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        this.userRepository.save(user);
    }

    public List<User> showUsers(){
        return this.userRepository.findAll();
    }
}
