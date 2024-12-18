package com.br.soluctions.attos.domus.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;

import com.br.soluctions.attos.domus.entities.Usuario;
import com.br.soluctions.attos.domus.repositories.NivelDeAcessoRepository;
import com.br.soluctions.attos.domus.repositories.UsuarioRepository;



@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository; 
    private NivelDeAcessoRepository nivelDeAcessoRepository; 
    private final BCryptPasswordEncoder bCryptPasswordEncoder; 
    private JwtDecoder jwtDecoder; 
    
    public UsuarioService(UsuarioRepository usuarioRepository, NivelDeAcessoRepository nivelDeAcessoRepository,BCryptPasswordEncoder bCryptPasswordEncoder,JwtDecoder jwtDecoder ){
        this.usuarioRepository = usuarioRepository;
        this.nivelDeAcessoRepository = nivelDeAcessoRepository; 
        this.bCryptPasswordEncoder = bCryptPasswordEncoder; 
    }

   
    
}
