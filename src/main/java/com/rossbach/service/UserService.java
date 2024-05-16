package com.rossbach.service;

import com.rossbach.entities.User;
import com.rossbach.repositories.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            this.userRepository.save(user);
        }
        else {
            throw new RuntimeException("Cet email ou ce nom d'utilisateur est déjà utilisé");
        }
        
    };

    public void deleteUser(int id) {
        this.userRepository.deleteById(id);
    }

    public User showUserById(int id) {
        Optional<User> showUser = this.userRepository.findById(id);
        return showUser.orElse(null);
    }

    public List<User> showUsers(){
        return this.userRepository.findAll();
    }
}
