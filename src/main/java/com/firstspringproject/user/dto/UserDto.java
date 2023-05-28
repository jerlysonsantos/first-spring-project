package com.firstspringproject.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;

public class UserDto {
  @NotNull(message = "Name is mandatory")
  private String name;

  @NotNull(message = "Name is mandatory")
  @Email(message = "Email invalid")
  private String email;

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
