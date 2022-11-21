package com.example.grievance_management_system.service;


import com.example.grievance_management_system.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getALLUser();
}