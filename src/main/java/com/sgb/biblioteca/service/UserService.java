package com.sgb.biblioteca.service;

import com.sgb.biblioteca.dao.UserDAO;
import com.sgb.biblioteca.model.UserModel;
import com.sgb.biblioteca.model.UserRole;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    public void save(UserModel user){
        user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

    public UserModel findByUsername(String username){
        return userDAO.findByUsername(username);
    }
}
