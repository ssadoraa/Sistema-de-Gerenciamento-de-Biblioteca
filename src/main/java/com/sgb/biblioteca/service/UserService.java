package com.sgb.biblioteca.service;

import com.sgb.biblioteca.dao.UserDAO;
import com.sgb.biblioteca.model.UserModel;
import com.sgb.biblioteca.model.Role;
import lombok.AllArgsConstructor;
import lombok.val;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    public void save(UserModel user){
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

    public UserModel findByUsername(String username){
        return userDAO.findByUsername(username);
    }
    
    public UserModel findUserById(Long id){
        return userDAO.findById(id).orElse(null);
    }

    public List<UserModel> findUserByQuery(String queyr){
        return userDAO.userQuery(queyr);
    }

    public String identificacaoLogado() {
        val authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
