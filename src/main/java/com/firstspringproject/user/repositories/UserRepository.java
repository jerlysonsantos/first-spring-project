package com.firstspringproject.user.repositories;

import org.springframework.data.repository.CrudRepository;

import com.firstspringproject.user.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
  
}
