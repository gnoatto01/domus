package com.br.soluctions.attos.domus.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.soluctions.attos.domus.dtos.LoginRequest;
import com.br.soluctions.attos.domus.dtos.LoginResponse;
import com.br.soluctions.attos.domus.repositories.UserRepository;
import com.br.soluctions.attos.domus.services.AuthenticationService;
import com.br.soluctions.attos.domus.utils.RemoveJsonParameters;

@RestController
@RequestMapping("/api")
public class TokenController {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    RemoveJsonParameters removeJsonParameters;

    public TokenController(AuthenticationService authenticationService, UserRepository userRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder, RemoveJsonParameters removeJsonParameters) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.removeJsonParameters = removeJsonParameters;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var user = userRepository.findByUsername(loginRequest.username());

        if (user.isEmpty() || !user.get().isCorrectLogin(loginRequest, bCryptPasswordEncoder)) {
            throw new BadCredentialsException("Usuario ou senha invalidos");
        }

        var accessToken = authenticationService.autenticate(loginRequest);

        return ResponseEntity.ok(new LoginResponse(accessToken));
    }

    @GetMapping("/verify-token")
    public boolean validateToken(@RequestHeader("Authorization") String accessToken) {
        accessToken = removeJsonParameters.removeParameters(accessToken, "accessToken");

        boolean isValid = authenticationService.validateToken(accessToken);

        if (isValid) {
            return true;
        } else {
            return false;
        }

    }
}
