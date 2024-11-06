package br.com.dev.api_service.repository;

import br.com.dev.api_service.domain.Role;
import br.com.dev.api_service.domain.User;
import br.com.dev.api_service.domain.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);
}
