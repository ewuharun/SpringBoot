package com.example.Ecommerce.Service;

import com.example.Ecommerce.Repository.UserRepository;
import com.example.Ecommerce.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println(userName);
        User aUser = userRepository.findByUserName(userName);
        return new org.springframework.security.core.userdetails.User(aUser.getUser_name(),aUser.getPassword(),new ArrayList<>());
    }
}
