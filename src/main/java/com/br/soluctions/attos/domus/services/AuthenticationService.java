package com.br.soluctions.attos.domus.services;

import org.springframework.stereotype.Service;

import com.br.soluctions.attos.domus.dtos.LoginRequest;

@Service
public class AuthenticationService {
    private final TokenService tokenService;

    public AuthenticationService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public String autenticate(LoginRequest loginRequest) {
        return tokenService.generateToken(loginRequest);
    }

    public boolean validateToken(String accessToken) {
        return tokenService.validateToken(accessToken);
    }
}
