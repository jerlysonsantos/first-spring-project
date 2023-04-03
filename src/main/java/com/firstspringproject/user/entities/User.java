package com.firstspringproject.user.entities;

import com.firstspringproject.user.interfaces.UserInterface;

public class User implements UserInterface{
  private String name;
  private String email;
  private int id;
  
  public User() { }

  public User(String name, String email, int id) throws Exception {
    this.name = name;
    this.email = email;
    this.id = id;
  }
  
  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public int getId() {
    return this.id;
  }

}
