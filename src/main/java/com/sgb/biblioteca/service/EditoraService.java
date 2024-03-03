package com.sgb.biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import lombok.val;
import com.sgb.biblioteca.dao.EditoraDAO;
import com.sgb.biblioteca.model.Editora;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EditoraService {
    
    private EditoraDAO editoraDAO;
    
    public void save(Editora editora){
        editora.limpaFormatacao();
        editoraDAO.save(editora);
    }

    public Editora findByIdCamposFormatados(Long id){
        val editora = editoraDAO.findById(id).orElse(null);
        editora.setCnpj(editora.formataCNPJ());
        editora.setTelefone(editora.formataTelefone());
        return editora;
    }

    public List<Editora> findEditoraByQuery(String nome){
        return editoraDAO.editoraQuery(nome);
    }

    public List<Editora> listagemEditoras(){
        return editoraDAO.listagemEditora().stream().map(editora -> {
                editora.setCnpj(editora.formataCNPJ());
                editora.setTelefone(editora.formataTelefone());
                return editora;
            }).collect(Collectors.toList());
    }

}
