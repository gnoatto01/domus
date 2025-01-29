package com.br.soluctions.attos.domus.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.br.soluctions.attos.domus.entities.User;
import com.br.soluctions.attos.domus.entities.AccessLevel.Values;
import com.br.soluctions.attos.domus.entities.Person;
import com.br.soluctions.attos.domus.repositories.AccessLevelRepository;
import com.br.soluctions.attos.domus.repositories.PersonRepository;
import com.br.soluctions.attos.domus.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Configuration
public class UserAdminConfig implements CommandLineRunner {
    private AccessLevelRepository accessLevelRepository;
    private UserRepository userRepository;
    private PersonRepository personRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserAdminConfig(AccessLevelRepository accessLevelRepository, UserRepository userRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder, PersonRepository personRepository) {
        this.accessLevelRepository = accessLevelRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.personRepository = personRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var adminAccesLevel = accessLevelRepository.findByAccessLevelName(Values.ADMINISTRADOR.name());
        var userAdmin = userRepository.findByUsername("admin");

        userAdmin.ifPresentOrElse(user -> {
            System.out.println("Admin exists: " + user);
        },
                () -> {
                    var user = new User();
                    var person = new Person();

                    user.setUsername("admin");
                    user.setPassword(bCryptPasswordEncoder.encode("@ttosAdmin"));
                    user.setAccessLevels(Set.of(adminAccesLevel));
                    user.setTenantId("domus_default");

                    person.setName("Atto's");
                    person.setLastName("Admin");
                    person.setEmail("contatognoatto01@gmail.com");
                    personRepository.save(person);

                    user.setPerson(person);

                    userRepository.save(user);
                });

    }

}
