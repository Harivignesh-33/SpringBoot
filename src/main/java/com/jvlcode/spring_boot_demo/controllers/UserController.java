package com.jvlcode.spring_boot_demo.controllers;

import com.jvlcode.spring_boot_demo.entity.UserEntity;
import com.jvlcode.spring_boot_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/Api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //    @GetMapping("/hari")
//    public String getUsers(){
//        return "Hello Hari";
//    }
//    ? get all user
    @GetMapping
    public List<UserEntity> getUsers() {
//        return Arrays.asList(new User(1L, "Hari", "hari@gmail.com"),
//                            new User(2L, "yavana", "yava@gmail.com"),
//                            new User(3L, "Ari", "Ari@gmail.com"));
        return userRepository.findAll();
    }
//      ? single user
    @GetMapping("/{id}")
    public  UserEntity getSingleUser(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not  found  with id "+id));
    }
//    ? insert data

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user){
        return userRepository.save(user);
    }


    //    ? Update data
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        // Find user by id
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        // Update fields
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        // Save updated user
        return userRepository.save(existingUser);
    }

//    ? Delete user
    @DeleteMapping("/{id}")
    public String  deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw  new RuntimeException("User not found with "+ id);
        }
        userRepository.deleteById(id);
       return "user deleted with id :"+id;
    }

}

