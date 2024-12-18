package com.br.soluctions.attos.domus.services;

import org.springframework.stereotype.Service;

import com.br.soluctions.attos.domus.dtos.RequisicaoDeLogin;

@Service
public class AutenticacaoService {
    private final TokenService tokenService; 

    public AutenticacaoService(TokenService tokenService){
        this.tokenService = tokenService; 
    }


    public String Autenticar(RequisicaoDeLogin requisicaoDeLogin) {
        return tokenService.gerarToken(requisicaoDeLogin);
    }


    public boolean ValidarToken(String tokenDeAcesso) {
        return tokenService.validarToken(tokenDeAcesso);
    }
}
