package com.learning.user.services;

import com.learning.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getAllUser();

    Optional<User> getUser(String id);

    User deleteUser(String id);

    User updateUser(User user);
}
