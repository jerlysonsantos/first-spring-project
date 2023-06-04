package com.firstspringproject.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.ResponseTransfer;
import com.firstspringproject.user.dto.UserDto;
import com.firstspringproject.user.entities.User;
import com.firstspringproject.user.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public Iterable<User> list() {
    return userRepository.findAll();
  }

  public ResponseTransfer insert(UserDto userDto) {

    ModelMapper modelMapper = new ModelMapper();

    User user = modelMapper.map(userDto, User.class);

    userRepository.save(user);

    return new ResponseTransfer("Usuário criado");
  }
}
