package com.br.soluctions.attos.domus.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.br.soluctions.attos.domus.entities.Usuario;
import com.br.soluctions.attos.domus.entities.NivelDeAcesso.Valores;
import com.br.soluctions.attos.domus.repositories.NivelDeAcessoRepository;
import com.br.soluctions.attos.domus.repositories.PessoaRepository;
import com.br.soluctions.attos.domus.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Configuration
public class ConfiguracaoUsuarioAdministrador implements CommandLineRunner  {
    private NivelDeAcessoRepository nivelDeAcessoRepository; 
    private UsuarioRepository usuarioRepository; 
    private PessoaRepository pessoaRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ConfiguracaoUsuarioAdministrador(NivelDeAcessoRepository nivelDeAcessoRepository, UsuarioRepository usuarioRepository, PessoaRepository pessoaRepository,BCryptPasswordEncoder bCryptPasswordEncoder ){
        this.nivelDeAcessoRepository = nivelDeAcessoRepository; 
        this.usuarioRepository = usuarioRepository; 
        this.pessoaRepository = pessoaRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder; 
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var nivelDeAcessoAdmin = nivelDeAcessoRepository.findByNomeNivelDeAcesso(Valores.ADMINISTRADOR.name()); 

        var usuarioAdmin = usuarioRepository.findByUsuario("admin"); 

        var pessoaAdmin = pessoaRepository.findById(1L)
        .orElseThrow(() -> new IllegalStateException("Pessoa com ID " + 1 + " não encontrada")); 

      
           usuarioAdmin.ifPresentOrElse(
                usuario -> {
                    System.out.println("Administrador existente: " + usuario);
                },
                () -> {
                    var usuario = new Usuario();
                    usuario.setUsuario("admin");
                    usuario.setPessoa(pessoaAdmin);
                    usuario.setSenha(bCryptPasswordEncoder.encode("@ttosAdmin"));
                    usuario.setNivelDeAcesso(Set.of(nivelDeAcessoAdmin));
                    usuario.setTenantId("domus_default");
            
                    usuarioRepository.save(usuario); 
                 
                });
    }
}
