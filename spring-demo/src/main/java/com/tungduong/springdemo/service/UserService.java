package com.tungduong.springdemo.service;

import com.tungduong.springdemo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public final List<User> userList = new ArrayList<>(List.of(new User(1L,"Nguyễn Văn A", "a.nguyen@example.com", "Hà Nội"),
            new User(2L,"Trần Thị B", "b.tran@example.com", "TP.HCM"),
            new User(3L,"Lê Văn C", "c.le@example.com", "Đà Nẵng"))
    );

    private Long nextId = (long)userList.size() + 1;

    public List<User> getUserList(){
        return userList;
    }
    public User createUser(User user){
        user.setId(nextId++);
        userList.add(user);
        return user;
    }

    public Optional<User> getUserById(Long id){
        for(User user:userList){
            if(user.getId() == id) return Optional.of(user);
        }
        return Optional.empty();
    }

    public User updateUser(User user){
        Optional<User> current = getUserById(user.getId());
       if(current.isEmpty()) return null;
        current.get().setName(user.getName());
        current.get().setEmail(user.getEmail());
        current.get().setAddress(user.getAddress());
        return  current.orElse(null);
    }
    public boolean deleteUser(Long id){
        Optional<User> current = getUserById(id);
        if(current.isEmpty()) return false;
        userList.remove(current.get());
        return true;
    }
}
