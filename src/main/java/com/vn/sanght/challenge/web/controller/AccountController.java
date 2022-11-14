package com.vn.sanght.challenge.web.controller;

import com.vn.sanght.challenge.web.vmodel.LoginVM;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

@RestController
public class AccountController {
    private final AuthenticationManager authenticationManager;

    public AccountController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * POST /login: To handle login logic and return a basic token.
     *
     * @param loginVM  The given credential info
     * @param response httpResponse instance
     * @return token info
     */
    @PostMapping(path = "/login", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authorize(@RequestBody LoginVM loginVM,
                                       HttpServletResponse response) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginVM.getUsername(),
                        loginVM.getPassword());

        try {
            Authentication authentication = this.authenticationManager
                    .authenticate(authenticationToken);
            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);
            String token = new String(
                    Base64.encodeBase64(loginVM.toBase64Text().getBytes()));
            response.addHeader("Authorization", "Basic " + token);
            Map<String, String> output =
                    Map.of("token", token, "type", "Basic");
            return ResponseEntity.ok(output);
        } catch (AuthenticationException ae) {
            return new ResponseEntity<>(
                    Collections.singletonMap("AuthenticationException",
                            ae.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
}
