package com.example.eschoolserver.service;

import com.example.eschoolserver.mapper.UserMapper;
import com.example.eschoolserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;
    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserByUsername(String username){
        return userMapper.getUserByUsername(username);
    }

    public void addUser(User user){
        userMapper.addUser(user);
    }
}
