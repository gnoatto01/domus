package com.br.soluctions.attos.domus.services;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Service;

import com.br.soluctions.attos.domus.dtos.LoginRequest;
import com.br.soluctions.attos.domus.entities.AccessLevel;
import com.br.soluctions.attos.domus.repositories.UserRepository;

@Service
public class TokenService {
    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;
    private final UserRepository usuarioRepository;

    public TokenService(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder, UserRepository usuarioRepository) {
        this.jwtEncoder = jwtEncoder;
        this.jwtDecoder = jwtDecoder;
        this.usuarioRepository = usuarioRepository;
    }

    public String generateToken(LoginRequest loginRequest) {
        var user = usuarioRepository.findByUsername(loginRequest.username());
        Instant now = Instant.now();
        long expiresIn = 10L;

        var scopes = user.get().getAccessLevels()
                .stream()
                .map(AccessLevel::getAccessLevelName)
                .collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder()
                .issuer("attos-soluctions")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .subject(user.get().getUserId().toString())
                .claim("scope", scopes)
                .claim("tenant:", user.get().getTenantId())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public boolean validateToken(String accessToken) {
        try {
            Instant now = Instant.now();
            Instant expireDate;

            if (accessToken != null) {
                Jwt tokenDecriptografado = jwtDecoder.decode(accessToken);
                expireDate = tokenDecriptografado.getExpiresAt();

                if (expireDate != null && expireDate.isAfter(now)) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (JwtException e) {
            System.err.println("Erro na validacao do token: " + e);
            return false;
        }
    }
}
