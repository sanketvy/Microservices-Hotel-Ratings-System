package com.learning.user.services.impl;

import com.learning.user.entity.User;
import com.learning.user.entity.repository.UserRepository;
import com.learning.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
         User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User deleteUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return user.get();
        } else {
            throw new RuntimeException("User not found with user id - " + id);
        }
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
