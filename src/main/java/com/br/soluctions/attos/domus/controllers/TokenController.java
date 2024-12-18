package com.br.soluctions.attos.domus.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.soluctions.attos.domus.dtos.RequisicaoDeLogin;
import com.br.soluctions.attos.domus.dtos.RespostaDeLogin;
import com.br.soluctions.attos.domus.repositories.UsuarioRepository;
import com.br.soluctions.attos.domus.services.AutenticacaoService;

@RestController
@RequestMapping("/api")
public class TokenController {
    private final AutenticacaoService autenticacaoService; 
    private final UsuarioRepository usuarioRepository; 
    private final BCryptPasswordEncoder bCryptPasswordEncoder; 

    public TokenController(AutenticacaoService autenticacaoService,UsuarioRepository  usuarioRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.autenticacaoService = autenticacaoService; 
        this.usuarioRepository = usuarioRepository; 
        this.bCryptPasswordEncoder = bCryptPasswordEncoder; 
    }

    @PostMapping("/logar")
    public ResponseEntity<RespostaDeLogin> efetuarLogin(@RequestBody RequisicaoDeLogin requisicaoDeLogin){
        var usuario = usuarioRepository.findByUsuario(requisicaoDeLogin.usuario()); 

           if (usuario.isEmpty() || !usuario.get().isLoginCorreto(requisicaoDeLogin, bCryptPasswordEncoder)) {
            throw new BadCredentialsException("Usuario ou senha invalidos");
        }

        var tokenDeAcesso = autenticacaoService.Autenticar(requisicaoDeLogin);

        return ResponseEntity.ok(new RespostaDeLogin(tokenDeAcesso)); 
    }
}
