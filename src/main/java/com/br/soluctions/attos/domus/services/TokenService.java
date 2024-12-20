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

import com.br.soluctions.attos.domus.dtos.RequisicaoDeLogin;
import com.br.soluctions.attos.domus.entities.NivelDeAcesso;
import com.br.soluctions.attos.domus.repositories.UsuarioRepository;

@Service
public class TokenService {
    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;
    private final UsuarioRepository usuarioRepository;

    public TokenService(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder, UsuarioRepository usuarioRepository) {
        this.jwtEncoder = jwtEncoder;
        this.jwtDecoder = jwtDecoder;
        this.usuarioRepository = usuarioRepository;
    }

    public String gerarToken(RequisicaoDeLogin requisicaoDeLogin) {
        var usuario = usuarioRepository.findByUsuario(requisicaoDeLogin.usuario());
        Instant agora = Instant.now();
        long expiraEm = 86400L;

        var scopes = usuario.get().getNivelDeAcesso()
                .stream()
                .map(NivelDeAcesso::getNomeNivelDeAcesso)
                .collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder()
                .issuer("attos-soluctions")
                .issuedAt(agora)
                .expiresAt(agora.plusSeconds(expiraEm))
                .subject(usuario.get().getUsuarioId().toString())
                .claim("scope", scopes)
                .claim("tenant:", usuario.get().getTenantId())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public boolean validarToken(String tokenDeAcesso) {
        try {
            Instant agora = Instant.now();
            Instant dataDeExpiracao;

            if (tokenDeAcesso != null) {
                Jwt tokenDecriptografado = jwtDecoder.decode(tokenDeAcesso);
                dataDeExpiracao = tokenDecriptografado.getExpiresAt();

                if (dataDeExpiracao != null && dataDeExpiracao.isAfter(agora)) {
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
