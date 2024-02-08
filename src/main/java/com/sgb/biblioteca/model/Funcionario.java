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
        return new Funcionario(null, "", null, null, "", "", "", "", null, "");
    }

    public String formataCPF() {
        String numCPF = cpf.replaceAll("[^0-9]", "");

        return String.format("%s.%s.%s-%s",
                numCPF.substring(0, 3),
                numCPF.substring(3, 6),
                numCPF.substring(6, 9),
                numCPF.substring(9));
    }
    
    public String formataCelular() {
        String numCelular = celular.replaceAll("[^0-9]", "");

        return String.format("(%s) %s-%s",
                numCelular.substring(0, 2),
                numCelular.substring(2, 7),
                numCelular.substring(7));
    }
   
    public void limpaFormatacao() {
        if (cpf != null) {
            cpf = cpf.replaceAll("[^0-9]", "");
        }
        
        if (celular != null) {
            celular = celular.replaceAll("[^0-9]", "");
        }
    }
}
