package com.sgb.biblioteca.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sgb.biblioteca.dao.EmprestimoDAO;
import com.sgb.biblioteca.model.Emprestimo;
import com.sgb.biblioteca.model.DTOs.EmprestimoDTO;
import com.sgb.biblioteca.model.comDependencias.EmprestimoComDependencia;
import lombok.val;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmprestimoService {

    private EmprestimoDAO emprestimoDAO;

    private UserService userService;
    
    private LivroService livroService;

    public void save(Emprestimo emprestimo){
        val livro = livroService.findLivroById(emprestimo.getLivroId());
        livro.setQuantidade(livro.getQuantidade() - 1);
        livroService.save(livro);
        emprestimoDAO.save(emprestimo);
    }

    public Emprestimo findEmprestimoById(Long id){
        return emprestimoDAO.findById(id).orElse(null);
    }

    public List<EmprestimoDTO> listagemEmprestimos(){
        return emprestimoDAO.listaEmprestimos();
    }

    // Método para EmprestimoComDependencia
    public EmprestimoComDependencia findEmprestimoComDependenciaById(Long id) {
        return emprestimoDAO.findById(id)
            .map(emprestimo -> {
                try {
                    return new EmprestimoComDependencia(
                        emprestimo.getId(),
                        livroService.findLivroById(emprestimo.getLivroId()),
                        userService.findUserById(emprestimo.getUserId()),
                        userService.findUserById(emprestimo.getFuncionarioId()),
                        emprestimo.getDataEmprestimo(),
                        emprestimo.getDataDevolucao()
                    );
                } catch (Exception e) {
                    throw new RuntimeException("Erro ao obter dependências do emprestimo " + e);
                }
            })
            .orElse(null);
    }   
}
