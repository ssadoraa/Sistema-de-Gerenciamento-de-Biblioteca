package com.sgb.biblioteca.dao;

import com.sgb.biblioteca.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}