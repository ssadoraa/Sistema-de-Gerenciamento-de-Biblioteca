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

    public String formataCNPJ() {
        String numCNPJ = cnpj.replaceAll("[^0-9]", "");

        //12.345.678/1234-56

        return String.format("%s.%s.%s/%s-%s",
                numCNPJ.substring(0, 2),
                numCNPJ.substring(2, 5),
                numCNPJ.substring(5, 8),
                numCNPJ.substring(8, 12),
                numCNPJ.substring(12));
    }
    
    public String formataTelefone() {
        String numTelefone = telefone.replaceAll("[^0-9]", "");

        return String.format("(%s) %s-%s",
                numTelefone.substring(0, 2),
                numTelefone.substring(2, 7),
                numTelefone.substring(7));
    }
   
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

