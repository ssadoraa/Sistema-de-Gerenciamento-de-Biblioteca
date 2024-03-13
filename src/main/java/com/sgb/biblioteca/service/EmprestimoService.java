package com.sgb.biblioteca.service;

import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sgb.biblioteca.dao.EmprestimoDAO;
import com.sgb.biblioteca.model.Emprestimo;
import com.sgb.biblioteca.model.Situacao;
import com.sgb.biblioteca.model.DTOs.EmprestimoDTO;
import com.sgb.biblioteca.model.comDependencias.EmprestimoComDependencia;
import lombok.AllArgsConstructor;
import lombok.val;

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
        
        emprestimo.setSituacao(Situacao.ABERTO);
        emprestimoDAO.save(emprestimo);
    }

    public Emprestimo findEmprestimoById(Long id){
        return emprestimoDAO.findById(id).orElse(null);
    }

    public List<EmprestimoDTO> listagemEmprestimos(){
        return emprestimoDAO.listaEmprestimos();
    }
    
    public List<EmprestimoDTO> listagemEmprestimosAbertos(){
        return emprestimoDAO.listaEmprestimosAbertos();
    }

    @Transactional
    public Emprestimo encerrarEmprestimo(Long id) {
        val emprestimo = findEmprestimoById(id);
        val livro = livroService.findLivroById(emprestimo.getLivroId());

        livro.setQuantidade(livro.getQuantidade() + 1);
        livroService.save(livro);

        emprestimoDAO.updateSituacao(id, Situacao.ENCERRADO);
        return emprestimo;
    }

    @Scheduled(fixedRate = 2000)
    public void atualizaEmprestimoAtrasado() {
        val emprestimos = emprestimoDAO.listaEmprestimos();

        emprestimos.forEach(emprestimo -> {
            if (emprestimo.getSituacao() != Situacao.ENCERRADO && emprestimo.calcularDiasRestantes() < 0) {
                emprestimoDAO.updateSituacao(emprestimo.getId(), Situacao.ATRASADO);
            }
        });
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
                        emprestimo.getDataDevolucao(),
                        emprestimo.getSituacao()
                    );
                } catch (Exception e) {
                    throw new RuntimeException("Erro ao obter dependências do emprestimo " + e);
                }
            })
            .orElse(null);
    }   
}
