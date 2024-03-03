package com.sgb.biblioteca.service;

import org.springframework.stereotype.Service;

import com.sgb.biblioteca.dao.EmprestimoDAO;
import com.sgb.biblioteca.model.Emprestimo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmprestimoService {

    private EmprestimoDAO emprestimoDAO;

    public void save(Emprestimo emprestimo){
        emprestimoDAO.save(emprestimo);
    }

    public Emprestimo findEmprestimoById(Long id){
        return emprestimoDAO.findById(id).orElse(null);
    }

}
