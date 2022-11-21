package com.example.grievance_management_system.Controller;

import com.example.grievance_management_system.Repository.UserRepository;
import com.example.grievance_management_system.exception.ResourceNotFoundException;
import com.example.grievance_management_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    //build get user by user_id REST API
    @GetMapping("{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable long user_id){
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with user_id:" + user_id));
        return ResponseEntity.ok(user);
    }
    @PutMapping("{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable long user_id, @RequestBody User userDetails){
        User updateUser = userRepository.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with user_id:" + user_id));

                updateUser.setEmail_id(userDetails.getEmail_id());
                updateUser.setName(userDetails.getName());
                updateUser.setPassword(userDetails.getPassword());
                updateUser.setPhone_no(userDetails.getPhone_no());
                updateUser.setForgot_password(userDetails.getForgot_password());

                userRepository.save(updateUser);

                return ResponseEntity.ok(updateUser);
    }


    @DeleteMapping("{user_id}")
    public ResponseEntity <HttpStatus> deleteUser(@PathVariable long user_id){
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with user_id:" + user_id));

        userRepository.delete(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}