package com.br.soluctions.attos.domus.services;

import org.springframework.stereotype.Service;

import com.br.soluctions.attos.domus.repositories.UserRepository;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean verifyEmail(String email) {
        boolean isExists = false;

        var emailResult = userRepository.findByPersonEmail(email);

        if (!emailResult.isEmpty()) {
            isExists = true;
        } else {
            isExists = false;
        }

        return isExists;

    }
}
