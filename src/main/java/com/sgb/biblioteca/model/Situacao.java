package com.sgb.biblioteca.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Situacao {
    ABERTO("Aberto"),
    ATRASADO("Atrasado"),
    ENCERRADO("Encerrado");

    private String nome;

    public String nome() {
		return nome;
	}
}
