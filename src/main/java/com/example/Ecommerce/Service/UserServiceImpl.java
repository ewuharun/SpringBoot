package com.example.Ecommerce.Service;


import com.example.Ecommerce.Model.UserRole;
import com.example.Ecommerce.Repository.UserRepository;
import com.example.Ecommerce.Model.User;
import com.example.Ecommerce.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<>();
        userRepository.findAll().forEach(user->list.add(user));
        System.out.println(list);
        return list;
    }

    @Override
    public User addUser(User aUser) {
        return userRepository.save(aUser);
    }

    @Override
    public UserRole assignRoleToUser(UserRole aUserRole) {
        return userRoleRepository.save(aUserRole);
    }
}

