package net.okur.gatewayservice.security.jwt;

import net.okur.gatewayservice.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dogancan.okur
 * 4.12.2022 03:56
 */
public interface IJwtProvider {
    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);

    String generateToken(UserPrincipal authentication);
}
