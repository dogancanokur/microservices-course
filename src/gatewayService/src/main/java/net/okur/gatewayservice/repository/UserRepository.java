package net.okur.gatewayservice.repository;

import net.okur.gatewayservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author dogancan.okur
 * 4.12.2022 01:04
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

}
