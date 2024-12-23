package com.br.soluctions.attos.domus.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.soluctions.attos.domus.dtos.RequisicaoDeLogin;
import com.br.soluctions.attos.domus.dtos.RespostaDeLogin;
import com.br.soluctions.attos.domus.repositories.UsuarioRepository;
import com.br.soluctions.attos.domus.services.AutenticacaoService;
import com.br.soluctions.attos.domus.utils.RemoverParametrosJson;

@RestController
@RequestMapping("/api")
public class TokenController {
    private final AutenticacaoService autenticacaoService;
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    RemoverParametrosJson removerParametrosJson;

    public TokenController(AutenticacaoService autenticacaoService, UsuarioRepository usuarioRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder, RemoverParametrosJson removerParametrosJson) {
        this.autenticacaoService = autenticacaoService;
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.removerParametrosJson = removerParametrosJson;
    }

   
    @PostMapping("/logar")
    public ResponseEntity<RespostaDeLogin> efetuarLogin(@RequestBody RequisicaoDeLogin requisicaoDeLogin) {
        var usuario = usuarioRepository.findByUsuario(requisicaoDeLogin.usuario());

        if (usuario.isEmpty() || !usuario.get().isLoginCorreto(requisicaoDeLogin, bCryptPasswordEncoder)) {
            throw new BadCredentialsException("Usuario ou senha invalidos");
        }

        var tokenDeAcesso = autenticacaoService.Autenticar(requisicaoDeLogin);

        return ResponseEntity.ok(new RespostaDeLogin(tokenDeAcesso));
    }

    @GetMapping("/verificar-token")
    public boolean validarToken(@RequestHeader("Authorization") String tokenDeAcesso) {
        tokenDeAcesso = removerParametrosJson.removerParametros(tokenDeAcesso, "tokenDeAcesso");

        boolean isValido = autenticacaoService.ValidarToken(tokenDeAcesso);

        if (isValido) {
            return true;
        } else {
            return false;
        }

    }
}
