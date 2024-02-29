package com.sgb.biblioteca.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sgb.biblioteca.dao.FuncionarioDAO;
import com.sgb.biblioteca.model.Funcionario;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private FuncionarioDAO funcionarioDAO;

    public void save(Funcionario funcionario){
        funcionarioDAO.save(funcionario);
    }

    public Funcionario findFuncionarioById(Long id){
        return funcionarioDAO.findById(id).orElse(null);
    }

    public List<Funcionario> findFuncionarioByQuery(String nome){
        List<Funcionario> funcionarios = funcionarioDAO.funcionarioQuery(nome);
        return funcionarios;
    }
}
