package net.okur.gatewayservice.service;

import net.okur.gatewayservice.model.User;

/**
 * @author dogancan.okur
 * 4.12.2022 21:06
 */
public interface IAuthenticationService {
    String singInAndReturnJwt(User signInRequest);
}
