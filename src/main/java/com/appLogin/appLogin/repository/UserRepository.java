package com.appLogin.appLogin.repository;

import com.appLogin.appLogin.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Usuario, String> {

    Usuario findById(long id);
}
