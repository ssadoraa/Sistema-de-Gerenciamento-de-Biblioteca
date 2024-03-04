package com.sgb.biblioteca.model.DTOs;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoDTO {
    Long id;
    String nome;
    String titulo;
    String autor;
    LocalDate dataDevolucao;

    public String prazo() {
        int diasRestantes = LocalDate.now().until(dataDevolucao).getDays();

        if (diasRestantes < 0) {
            return "<span class=\"text-danger fw-bold\">Atrasado</span>";
        } else if (diasRestantes <= 10) {
            return "<span class=\"text-warning fw-bold\">Faltando " + diasRestantes + " dia(s)</span>";
        } else {
            return "<span class=\"text-primary\">" + diasRestantes + " dias restantes</span>";
        }
    }
}
