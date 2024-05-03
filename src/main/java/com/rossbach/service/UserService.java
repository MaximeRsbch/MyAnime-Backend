package com.rossbach.service;

import com.rossbach.entities.User;
import com.rossbach.repositories.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        User userDansLaBDD = this.userRepository.findByEmail(user.getEmail());
        User otherUserDansLaBDD = this.userRepository.findByUsername(user.getUsername());
        if (userDansLaBDD == null && otherUserDansLaBDD == null) {
            this.userRepository.save(user);
        }
        else {
            throw new RuntimeException("Cet email ou ce nom d'utilisateur est déjà utilisé");
        }
        
    }

    public List<User> showUsers(){
        return this.userRepository.findAll();
    }
}
