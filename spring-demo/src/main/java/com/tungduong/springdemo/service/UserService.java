package com.tungduong.springdemo.service;

import com.tungduong.springdemo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    public final List<User> userList = new ArrayList<>(List.of(new User(1,"Nguyễn Văn A", "a.nguyen@example.com", "Hà Nội"),
            new User(2,"Trần Thị B", "b.tran@example.com", "TP.HCM"),
            new User(3,"Lê Văn C", "c.le@example.com", "Đà Nẵng"))
    );

    private long nextId = userList.size() + 1;

    public List<User> getUserList(){
        return userList;
    }
    public User createUser(User user){
        user.setId(nextId);
        userList.add(user);
        return user;
    }
}
