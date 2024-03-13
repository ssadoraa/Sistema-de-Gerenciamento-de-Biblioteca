package com.sgb.biblioteca.dao;

import com.sgb.biblioteca.model.UserModel;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<UserModel, Long> {
    UserModel findByUsername(String username);

    @Query("SELECT u.id, u.nome, u.cpf FROM biblioteca.user u "
           + " WHERE u.cpf LIKE CONCAT('%', :query, '%')"
           + " AND u.role = 'USER';")
    List<UserModel> userQuery(String query);

    @Query("SELECT * FROM biblioteca.user u "+
           " WHERE u.role = 'ATENDENTE' " +
           " ORDER BY u.nome;")
    List<UserModel> listagemFuncionario();
}