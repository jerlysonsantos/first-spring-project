package com.firstspringproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstspringproject.user.entities.User;
import com.firstspringproject.user.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public Iterable<User> list() {
    return userRepository.findAll();
  }  
}
