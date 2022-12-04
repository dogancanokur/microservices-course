package net.okur.gatewayservice.service;

import net.okur.gatewayservice.model.User;

import java.util.List;

/**
 * @author dogancan.okur
 * 4.12.2022 01:00
 */
public interface IUserService {

    List<User> getAllUsers();

    User getUserById(Long userId);

    User getUserByUsername(String username);

    void deleteUser(Long userId);

    User saveUser(User user);
}
