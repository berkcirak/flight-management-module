package com.example.flightmodule.service;


import com.example.flightmodule.entity.User;
import com.example.flightmodule.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    //transactional i denetle
    //autowired i denetle
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> result=userRepository.findById(id);
        User user=null;
        if(result.isPresent()){
            user=result.get();
        }
        else{
            throw new RuntimeException("user is not found");
        }
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteById(int id) {
        userRepository.deleteById(id);
        return null;
    }
}
