package com.sgb.biblioteca.service;

import com.sgb.biblioteca.dao.UserDAO;
import com.sgb.biblioteca.model.UserModel;
import com.sgb.biblioteca.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.val;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    public void saveNewUser(UserModel user){
        save(user, UserRole.USER);
    }
    
    public void saveNewFuncionario(UserModel user){
        save(user, UserRole.ATENDENTE);
    }
    
    public void saveEdit(UserModel user){
        save(user, user.getRole());
    }

    private void save(UserModel user, UserRole role){
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.limpaFormatacao();
        userDAO.save(user);
    }

    public UserModel findByUsername(String username){
        return userDAO.findByUsername(username);
    }
    
    public UserModel findById(Long id){
        return userDAO.findById(id).orElse(null);
    }

    public UserModel findByIdCamposFormatados(Long id){
        val user = userDAO.findById(id).orElse(null);
        user.setCpf(user.formataCPF());
        user.setTelefone(user.formataTelefone());
        return user;
    }
    
    public List<UserModel> findUserByQuery(String queyr){
        return userDAO.userQuery(queyr);
    }

    public List<UserModel> listagemFuncionarios(){
        return userDAO.listagemFuncionario().stream().map(funcionario -> {
            funcionario.setTelefone(funcionario.formataTelefone());
            return funcionario;
        }).collect(Collectors.toList());
    }

    public List<UserModel> findFuncionarioByQuery(String nome){
        return userDAO.funcionarioQuery(nome);
    }

}
