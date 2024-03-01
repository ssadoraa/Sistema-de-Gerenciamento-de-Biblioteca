package com.sgb.biblioteca.dao;

import com.sgb.biblioteca.model.UserModel;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<UserModel, Long> {
    UserModel findByUsername(String username);

    @Query("SELECT u.id, u.username, u.cpf FROM biblioteca.user u "
           + " WHERE u.username LIKE CONCAT('%', :username, '%')")
    List<UserModel> userQuery(String username);
}