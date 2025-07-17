package com.udea.flotasql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udea.flotasql.entity.Role;
import com.udea.flotasql.entity.User;
import com.udea.flotasql.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User register(String name, String ssn, String password, String email, Role role) {
    User user = new User();

    user.setName(name);
    user.setSsn(ssn);
    user.setPassword(password);
    user.setEmail(email);
    user.setRole(role);

    return userRepository.save(user);
  } 

  public List<User> getAllUsers() {
    return userRepository.findAll();
  };

  public User updateProfile(Long id, String name, String ssn, String password, String email, Role role) {
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    if (name != null) user.setName(name);
    if (ssn != null) user.setSsn(ssn);
    if (password != null) user.setPassword(password); // Asegúrate de hashearla si es necesario
    if (email != null) user.setEmail(email);
    if (role != null) user.setRole(role);

    return userRepository.save(user);
  }

  public void deleteUserById(Long id){
    userRepository.deleteById(id);
  }

}








