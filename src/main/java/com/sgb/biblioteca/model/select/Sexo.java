package com.sgb.biblioteca.model.select;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sexo {
    Masculino("Masculino"),
    Feminino("Feminino"),
    Nao_informado("Prefiro não dizer"),
    Outro("Outro");
    
    private final String nome;
}
