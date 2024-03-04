package com.sgb.biblioteca.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroAutorDTO {
    Long id;
    String titulo;
    String nome;
    Integer quantidade;
}
