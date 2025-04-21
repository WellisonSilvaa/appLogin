package com.appLogin.appLogin.repository;

import com.appLogin.appLogin.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Usuario, String> {

    Usuario findById(long id);

    @Query(value ="SELECT * FROM applogin.table_user WHERE email = :email AND password = :password", nativeQuery = true)
    public Usuario login(String email, String password);

}
