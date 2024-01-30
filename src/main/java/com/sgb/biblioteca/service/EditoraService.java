package com.sgb.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.val;
import com.sgb.biblioteca.dao.EditoraDAO;
import com.sgb.biblioteca.model.Editora;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EditoraService {
    
    private EditoraDAO editoraDAO;
    
    public Editora findById(Long id) {
        return editoraDAO.findById(id).orElse(null);
    }

    public void save(Editora editora){
        editora.limpaFormatacao();
        editoraDAO.save(editora);
    }
    
    public Editora findByIdFormatado(Long id){
        val editora = editoraDAO.findById(id).orElse(null);
        editora.setCnpj(editora.formataCNPJ());
        editora.setTelefone(editora.formataTelefone());
        return editora;
    }

    public List<Editora> findEditoraByQuery(String nome){
        List<Editora> editoras = editoraDAO.editoraQuery(nome);
        return editoras;
    }

    public List<Editora> listagemEditoras(){
        return editoraDAO.listagemEditora();
    }

}
