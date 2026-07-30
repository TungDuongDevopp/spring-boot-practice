package com.tungduong.springdemo.service;

import com.tungduong.springdemo.model.User;
import com.tungduong.springdemo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        public List<User> getAllUser() {
            return userRepository.findAll();
        }

        public User createUser(User user) {

            String hashPassword = this.passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            this.userRepository.save(user);
            return user;


        }

        public Optional<User> findUserById(Long id) {
            return userRepository.findById(id);
        }

        public User updateUser(User inputUser) {
            Optional<User> opt = findUserById(inputUser.getId());
            if(opt.isEmpty()) return null;
            User currentUserInDB = opt.get();
            currentUserInDB.setName(inputUser.getName());
            currentUserInDB.setEmail(inputUser.getEmail());
            currentUserInDB.setAddress(inputUser.getAddress());
            currentUserInDB.setRole(inputUser.getRole());
            userRepository.save(currentUserInDB);
            return currentUserInDB;
        }
        public boolean deleteUserById(Long id) {
        if(!userRepository.existsById(id)) return false;
        userRepository.deleteById(id);
        return true;
        }

        public Optional<User> getUserByEmail(String email) {
           return userRepository.findByEmail(email);
        }

         public boolean isEmailExist(String email) {
        return this.userRepository.existsByEmail(email);
        }

         public User handleRegister(User user) {
             String hashPassword = this.passwordEncoder.encode(user.getPassword());
             user.setPassword(hashPassword);
             user.setRole("USER");
             userRepository.save(user);
             return user;

        }
}





