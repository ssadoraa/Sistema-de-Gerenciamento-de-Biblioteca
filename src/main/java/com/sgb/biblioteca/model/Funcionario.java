package com.sgb.biblioteca.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.sgb.biblioteca.model.select.Sexo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "funcionario")
public class Funcionario {
    @Id
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private String cpf;
    private String endereco;
    private String celular;
    private String email;
    private LocalDate dataAdmissao;
    private String cargo;

    public static Funcionario empty() {
        return new Funcionario(null, "", null, null, "", "", "", "", LocalDate.now(), "");
    }
}
