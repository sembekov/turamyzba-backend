package com.app.turamyzba.services;

import com.app.turamyzba.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUser(long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
}
