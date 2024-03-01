package com.sgb.biblioteca.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.sgb.biblioteca.dao.UserDAO;
import com.sgb.biblioteca.model.UserModel;
import com.sgb.biblioteca.model.UserRole;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private UserDAO userDAO;

    private PasswordEncoder passwordEncoder;

    public void save(UserModel funcionario){
        funcionario.setRole(UserRole.ATENDENTE);
        funcionario.setPassword(passwordEncoder.encode(funcionario.getPassword()));
        funcionario.limpaFormatacao();
        userDAO.save(funcionario);
    }

    public UserModel findFuncionarioById(Long id){
        return userDAO.findById(id).orElse(null);
    }
}
