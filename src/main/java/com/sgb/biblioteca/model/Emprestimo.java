package com.sgb.biblioteca.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emprestimo")
public class Emprestimo {
    @Id Long id;
    @NotNull Long livroId;
    @NotNull Long clienteId;
    @NotNull Long funcionarioId;
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;
    
    public static Emprestimo empty() {
        return new Emprestimo(null, null, null, null, LocalDate.now(), LocalDate.now().plusDays(45));
    }
}
