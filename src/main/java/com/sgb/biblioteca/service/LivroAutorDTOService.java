package com.sgb.biblioteca.service;

import org.springframework.stereotype.Service;

import com.sgb.biblioteca.dao.LivroAutorDTODAO;
import com.sgb.biblioteca.model.DTOs.LivroAutorDTO;
import java.util.List;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LivroAutorDTOService {
    
    private LivroAutorDTODAO livroAutorDTODAO;

    public LivroAutorDTO findLivroAutorDTOById(Long id){
        return livroAutorDTODAO.findById(id).orElse(null);
    }

    public List<LivroAutorDTO> findLivroByQuery(String titulo){
        return livroAutorDTODAO.livroAutorQuery(titulo);
    }

}
