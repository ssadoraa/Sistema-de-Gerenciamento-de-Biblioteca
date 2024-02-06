package com.sgb.biblioteca.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LivroAutorDTO {
    Long id;
    String titulo;
    String nome;
    Integer quantidade;
}
