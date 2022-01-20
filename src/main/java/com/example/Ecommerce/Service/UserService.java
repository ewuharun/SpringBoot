package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.User;
import com.example.Ecommerce.Model.UserRole;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User addUser(User aUser);
    UserRole assignRoleToUser(UserRole userRole);
}
