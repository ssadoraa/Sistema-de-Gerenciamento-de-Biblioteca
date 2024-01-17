package com.sgb.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Getter
@Setter
@Table(name = "genero")
public class Genero {
    @Id
    private long id;
    private String nome;

}
