package com.sgb.biblioteca.service;

import org.springframework.stereotype.Service;

import com.sgb.biblioteca.dao.LivroAutorDTODAO;
import com.sgb.biblioteca.dao.LivroDAO;
import com.sgb.biblioteca.model.Livro;
import com.sgb.biblioteca.model.DTOs.LivroAutorDTO;
import java.util.List;
import lombok.val;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LivroAutorDTOService {
    
    private LivroAutorDTODAO livroAutorDTODAO;

    private LivroDAO livroDAO;

    private AutorService autorService;

    public LivroAutorDTO findLivroAutorDTOById(Long id) {
        val livro = livroDAO.findById(id).orElse(null);

        if (livro != null) {
            return convertToLivroAutorDTO(livro);
        } else {
            return null;
        }
    }

    private LivroAutorDTO convertToLivroAutorDTO(Livro livro) {
        LivroAutorDTO livroAutorDTO = new LivroAutorDTO();
        
        livroAutorDTO.setId(livro.getId());
        livroAutorDTO.setTitulo(livro.getTitulo());
        livroAutorDTO.setNome(autorService.findById(livro.getAutorId()).getNome());
        
        return livroAutorDTO;
    }

    public List<LivroAutorDTO> findLivroByQuery(String titulo){
        return livroAutorDTODAO.livroAutorQuery(titulo);
    }

}
