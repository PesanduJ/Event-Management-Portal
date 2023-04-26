package com.eventmanagementportal.eventmanagementportal.service;

import com.eventmanagementportal.eventmanagementportal.entity.User;
import com.eventmanagementportal.eventmanagementportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String login(String username, String password) {
        String role = userRepository.findRoleByUsernameAndPassword(username, password);
        if (role == null) {
            return "Wrong credentials!";
        } else if (role.equals("ADMIN")) {
            return "ADMIN";
        } else {
            return "USER";
        }
    }
}
