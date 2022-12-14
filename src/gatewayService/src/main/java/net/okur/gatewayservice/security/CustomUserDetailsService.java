package net.okur.gatewayservice.security;

import net.okur.gatewayservice.model.User;
import net.okur.gatewayservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author dogancan.okur
 * 4.12.2022 03:07
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + username));
        return new UserPrincipal(user.getId(), user.getUsername(), user.getPassword());
    }
}
