package com.firstspringproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.common.utils.ResponseTransfer;
import com.firstspringproject.user.dto.UserDto;
import com.firstspringproject.user.entities.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("")
  public @ResponseBody Iterable<User> list() {
    return this.userService.list();
  }

  @PostMapping("")
  public @ResponseBody ResponseTransfer insert(@Valid @RequestBody UserDto userDto) {
    return this.userService.insert(userDto);
  }
}
