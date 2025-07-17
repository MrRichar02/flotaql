package com.udea.flotasql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.udea.flotasql.entity.Role;
import com.udea.flotasql.entity.User;
import com.udea.flotasql.service.UserService;

@Controller
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @MutationMapping
  public User register(@Argument String name, @Argument String ssn, @Argument String password, @Argument String email, @Argument Role role) {
    return userService.register(name, ssn, password, email, role);
  }

  @MutationMapping
  public User updateUser(@Argument Long id, @Argument String name, @Argument String ssn, @Argument String password, @Argument String email, @Argument Role role) {
    return userService.updateProfile(id, name, ssn, password, email, role);
  }

  @MutationMapping
  public Boolean deleteUser(@Argument Long id) {
    userService.deleteUserById(id);
    return true;
  }

  @QueryMapping
  public List<User> allUsers() {
    return userService.getAllUsers();
  }

}
