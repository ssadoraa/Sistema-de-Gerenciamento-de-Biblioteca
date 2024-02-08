package com.sgb.biblioteca.service;

import org.springframework.stereotype.Service;
import lombok.val;
import com.sgb.biblioteca.dao.FuncionarioDAO;
import com.sgb.biblioteca.model.Funcionario;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private FuncionarioDAO funcionarioDAO;

    public void save(Funcionario funcionario){
        funcionario.limpaFormatacao();
        funcionarioDAO.save(funcionario);
    }

    public Funcionario findByIdCamposFormatados(Long id){
        val funcionario = funcionarioDAO.findById(id).orElse(null);
        funcionario.setCpf(funcionario.formataCPF());
        funcionario.setCelular(funcionario.formataCelular());
        return funcionario;
    }

    public List<Funcionario> listagemFuncionarios(){
        return funcionarioDAO.listagemFuncionario().stream().map(funcionario -> {
            funcionario.setCelular(funcionario.formataCelular());
            return funcionario;
        }).collect(Collectors.toList());
    }
}
