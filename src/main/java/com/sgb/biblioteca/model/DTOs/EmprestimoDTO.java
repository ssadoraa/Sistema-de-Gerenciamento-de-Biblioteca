package com.sgb.biblioteca.model.DTOs;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.sgb.biblioteca.model.Situacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.val;

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
    Situacao situacao;

    public long calcularDiasRestantes() {
        return ChronoUnit.DAYS.between(LocalDate.now(), dataDevolucao);
    }

    public String prazo() {
        val diasRestantes = calcularDiasRestantes();

        if (situacao == Situacao.ABERTO){
            if (diasRestantes == 0) {
                return "<span class=\"text-warning fw-bold\">Último dia</span>";
            } else if (diasRestantes <= 10){
                return "<span class=\"text-warning fw-bold\">" + diasRestantes + " dia(s) restante(s)</span>";
            }
            else {
                return "<span class=\"text-primary\">" + diasRestantes + " dias restantes</span>";
            }
        }
        else if (situacao == Situacao.ATRASADO){
            return "<span class=\"text-danger fw-bold\">ATRASADO</span>";
        }
        return "<span class=\"text-success fw-bold\">ENCERRADO</span>";
    }
}
