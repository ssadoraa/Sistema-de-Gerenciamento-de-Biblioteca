package com.sgb.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "editora")
public class Editora {
    @Id
    private Long id;
    private String nome;
    private String endereco;
    private String cnpj;
    private String telefone;
    private String descricao;

    public static Editora empty(){
        return new Editora(null, "", "", "", "", "");
    }

    public void limpaFormatacao() {
        if (cnpj != null) {
            cnpj = cnpj.replaceAll("[^0-9]", "");
        }
        
        if (telefone != null) {
            telefone = telefone.replaceAll("[^0-9]", "");
        }
    }

}

