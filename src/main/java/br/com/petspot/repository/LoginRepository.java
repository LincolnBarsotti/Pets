package br.com.petspot.repository;

import br.com.petspot.model.entity.login.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * @author Lincoln
 */
public interface LoginRepository extends JpaRepository<Login, String> {
    UserDetails findByEmailLogin(String login);
    boolean existsLoginByEmailLogin(String email);
}
