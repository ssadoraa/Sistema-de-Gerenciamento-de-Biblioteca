package com.sgb.biblioteca.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserModel {
    @Id
    private Long id;
    @NonNull private String nome;
    private LocalDate dataNascimento;
    @NonNull private String sexo;
    @NonNull private String cpf;
    @NonNull private String endereco;
    @NonNull private String telefone;
    @NonNull private String email;
    @NonNull private String username;
    @NonNull private String password;
    @NonNull private UserRole role;
    @NonNull private LocalDate dataCadastro;

    public static UserModel empty() {
        return new UserModel(null,"", null, "", "", "", "", "", "", "", UserRole.USER, LocalDate.now());
    }

    public void limpaFormatacao() {
        if (cpf != null) {
            cpf = cpf.replaceAll("[^0-9]", "");
        }

        if (telefone != null) {
            telefone = telefone.replaceAll("[^0-9]", "");
        }
    }
}