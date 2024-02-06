package com.sgb.biblioteca.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserModel {
    @Id
    private long id;
    @NonNull private String username;
    @NonNull private String password;
    @NonNull private String cpf;
    @NonNull private LocalDate dataNascimento;
    @NonNull private String sexo;
    @NonNull private String endereco;
    @NonNull private String telefone;
    @NonNull private String email;
    @NonNull private UserRole role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
