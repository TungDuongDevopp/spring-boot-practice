package com.tungduong.springdemo.service;

import com.tungduong.springdemo.model.User;
import com.tungduong.springdemo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository,PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

   public void createUser(User user){
        String hashPassword = passwordEncoder.encode(user.getPassword());
        boolean checkPass = passwordEncoder.matches(user.getPassword(),hashPassword);
        user.setPassword(hashPassword);
        repository.save(user);
   }
   public List<User> getAllUser(){
        List<User> userList = repository.findAll();
        return userList;
   }

   public Optional<User> getUserById(Long id){
       return repository.findById(id);
   }

    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);
    }

   public User updateUser(User user){

        Optional<User> optional = getUserById(user.getId());
        if(optional.isEmpty()) return null;

        User currentUser = optional.get();
        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        currentUser.setAddress(user.getAddress());
        repository.save(currentUser);
        return currentUser;
   }
   public boolean deleteUser (Long id){
       if(repository.existsById(id)) return false;
       repository.deleteById(id);
       return true;
   }
   public Optional<User> getUserByName(String name){
        return repository.findByName(name);
   }
}
