package net.okur.gatewayservice.service.impl;

import net.okur.gatewayservice.model.User;
import net.okur.gatewayservice.security.UserPrincipal;
import net.okur.gatewayservice.security.jwt.IJwtProvider;
import net.okur.gatewayservice.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @author dogancan.okur
 * 4.12.2022 21:42
 */
@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IJwtProvider iJwtProvider;

    public String singInAndReturnJwt(User signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return iJwtProvider.generateToken(userPrincipal);

    }

}
