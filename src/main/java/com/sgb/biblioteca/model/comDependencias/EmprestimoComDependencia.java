package com.sgb.biblioteca.model.comDependencias;

import java.time.LocalDate;
import com.sgb.biblioteca.model.Livro;
import com.sgb.biblioteca.model.UserModel;

public record EmprestimoComDependencia(
    long id,
    Livro livro,
    UserModel user,
    UserModel funcionario,
    LocalDate dataEmprestimo,
    LocalDate dataDevolucao) {

}