package com.example.grievance_management_system;

import com.example.grievance_management_system.Repository.UserRepository;
import com.example.grievance_management_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrievanceManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
          SpringApplication.run(GrievanceManagementSystemApplication.class, args);
    }


    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail_id("ramsingh123@gmail.com");
        user.setName("Ram Singh");
        user.setPassword("12345");
        user.setPhone_no("7205894607");
        user.setForgot_password("12335");
        userRepository.save(user);

    }
}
