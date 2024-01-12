package com.sgb.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Editora {
    @Id
    private long id;
    private String nome;
    private String endereco;
    private String cnpj;
    private String telefone;
    private String desricao;

}

