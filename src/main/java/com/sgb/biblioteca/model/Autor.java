package com.sgb.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "autor")
public class Autor {
    @Id
    private Long id;
    private String nome;
    private String pseudonimo;
    private LocalDate dataNascimento;
    private String biografia;

    public static Autor empty(){
        return new Autor(null, "", "", null, "");
    }
}
