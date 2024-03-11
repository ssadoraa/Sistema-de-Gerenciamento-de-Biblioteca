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
    @Id private Long id;
    @NotNull private Long livroId;
    @NotNull private Long userId;
    @NotNull private Long funcionarioId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    
    public static Emprestimo empty() {
        return new Emprestimo(null, null, null, null, LocalDate.now(), LocalDate.now().plusDays(45));
    }
}
