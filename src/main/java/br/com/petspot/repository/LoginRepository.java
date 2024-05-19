package br.com.petspot.repository;

import br.com.petspot.model.entity.login.Login;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Lincoln
 */
public interface LoginRepository extends JpaRepository<Login, String> {
    Login findByEmailAndPasswordLogin(String email, String senha);

    boolean existsLoginByEmail(String email);
}
