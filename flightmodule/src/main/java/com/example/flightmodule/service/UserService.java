package com.example.flightmodule.service;

import com.example.flightmodule.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(int id);
    User save(User user);
    User deleteById(int id);


}
