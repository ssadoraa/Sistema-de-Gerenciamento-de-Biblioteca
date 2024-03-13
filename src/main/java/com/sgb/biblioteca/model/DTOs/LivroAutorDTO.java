package com.sgb.biblioteca.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroAutorDTO {
    Long id;
    String titulo;
    String nome;
    Integer quantidade;

    public String quantidadeDisponivel() {
        if (quantidade <= 0) {
            return "<span class=\"text-danger fw-bold\">Livro não disponível</span>";
        }

        return "<span class=\"text-primary\">" + quantidade + " cópias</span>";
    }
}
