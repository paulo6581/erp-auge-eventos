package br.com.erp.augeventos.model.repository;

import br.com.erp.augeventos.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository  extends JpaRepository<UserModel, Integer> {
    UserModel findByUsername(String username);
}
