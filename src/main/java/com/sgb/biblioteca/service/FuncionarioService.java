package com.sgb.biblioteca.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.val;
import com.sgb.biblioteca.model.Role;
import java.util.stream.Collectors;
import com.sgb.biblioteca.dao.UserDAO;
import com.sgb.biblioteca.model.UserModel;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private UserDAO userDAO;
    
    private PasswordEncoder passwordEncoder;
    
    public void save(UserModel funcionario){
        funcionario.setRole(Role.ATENDENTE);
        funcionario.setPassword(passwordEncoder.encode(funcionario.getPassword()));
        funcionario.limpaFormatacao();
        userDAO.save(funcionario);
    }
    
    public UserModel findFuncionarioById(Long id){
        return userDAO.findById(id).orElse(null);
    }

    public UserModel findByIdCamposFormatados(Long id){
        val funcionario = userDAO.findById(id).orElse(null);
        System.out.println(funcionario);
        funcionario.setCpf(funcionario.formataCPF());
        funcionario.setTelefone(funcionario.formataTelefone());
        return funcionario;
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
