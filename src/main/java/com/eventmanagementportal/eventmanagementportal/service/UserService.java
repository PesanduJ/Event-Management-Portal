package com.eventmanagementportal.eventmanagementportal.service;

import com.eventmanagementportal.eventmanagementportal.entity.User;

public interface UserService {

    User addUser(User user);

    String login(String username, String password);
}
