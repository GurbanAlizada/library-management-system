package com.example.librarysystem.service;


import com.example.librarysystem.exception.UserNotFoundException;
import com.example.librarysystem.model.User;
import com.example.librarysystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    protected User getById(String id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("user not found : " + id));
    }

    protected User getByFinCode(String finCode){
      return   userRepository.getByFinCode(finCode)
              .orElseThrow(()->new UserNotFoundException("user not found : " + finCode));
    }


}
