package com.br.soluctions.attos.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.br.soluctions.attos.entities.Usuario;
import com.br.soluctions.attos.entities.NivelDeAcesso.Values;
import com.br.soluctions.attos.repositories.NivelDeAcessoRepository;
import com.br.soluctions.attos.repositories.UsuarioRepository;

@Configuration
public class ConfiguracaoUsuarioAdministrador implements CommandLineRunner {
    private NivelDeAcessoRepository nivelDeAcessoRepository; 
    private UsuarioRepository usuarioRepository; 
    private BCryptPasswordEncoder bCryptPasswordEncoder; 

    public ConfiguracaoUsuarioAdministrador(NivelDeAcessoRepository nivelDeAcessoRepository, UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.nivelDeAcessoRepository = nivelDeAcessoRepository; 
        this.usuarioRepository = usuarioRepository; 
        this.bCryptPasswordEncoder = bCryptPasswordEncoder; 
    }

    @Override
    public void run(String... args) throws Exception {
       var nivelAcessoAdmin = nivelDeAcessoRepository.findByNomeNivelAcesso(Values.ADMINISTRADOR.name()); 

       var usuarioAdmin = usuarioRepository.findByUsuario("admin"); 

       usuarioAdmin.ifPresentOrElse(
        usuario -> {
            System.out.println("O usuario administrador existe");
        },
        () -> {
            var usuario = new Usuario(); 
            usuario.setNome("Atto's");
            usuario.setSobrenome("Admin");
            usuario.setUsuario("attosAdmin");
            usuario.setSenha(bCryptPasswordEncoder.encode("@dminAttos"));
            usuario.setEmail("contatognoatto01@gmail.com");
            usuario.setNivelDeAcessoUsuario(Set.of(nivelAcessoAdmin));
            usuarioRepository.save(usuario); 

        });
    }



}
