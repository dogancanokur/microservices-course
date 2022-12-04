package net.okur.gatewayservice.repository;

import net.okur.gatewayservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dogancan.okur
 * 4.12.2022 01:04
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

}
