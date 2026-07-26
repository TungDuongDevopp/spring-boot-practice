package com.tungduong.springdemo.service;

import com.tungduong.springdemo.model.User;
import com.tungduong.springdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

   public void createUser(User user){
        repository.save(user);
   }
   public List<User> readUser(){
        List<User> userList = repository.findAll();
        return userList;
   }

   public Optional<User> getUserById(Long id){
       return repository.findById(id);
   }

   public User updateUser(User user){
        User currentUser = getUserById(user.getId()).get();
        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        currentUser.setAddress(user.getAddress());
        repository.save(currentUser);
        return currentUser;
   }
   public boolean deleteUser (Long id){
       User currentUser = getUserById(id).get();
       if (currentUser==null) return false;
       repository.deleteById(id);
       return true;
   }
   public Optional<User> getUserByName(String name){
        return repository.findByName(name);
   }
}
