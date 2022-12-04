package net.okur.gatewayservice.controller;

import net.okur.gatewayservice.model.User;
import net.okur.gatewayservice.service.IAuthenticationService;
import net.okur.gatewayservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dogancan.okur
 * 4.12.2022 23:00
 */
@RestController
@RequestMapping("/api/authentication") // pre-path
public class AuthenticationController {

    private final IAuthenticationService authenticationService;
    private final IUserService userService;

    @Autowired
    public AuthenticationController(IAuthenticationService authenticationService, IUserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("sign-up") // /api/authentication/sign-up
    public ResponseEntity<?> signUp(@RequestBody User user) {

        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);

    }

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user) {

        return new ResponseEntity<>(authenticationService.singInAndReturnJwt(user), HttpStatus.OK);

    }
}
