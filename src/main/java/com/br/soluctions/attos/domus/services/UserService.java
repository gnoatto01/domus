package com.br.soluctions.attos.domus.services;

import org.springframework.stereotype.Service;

import com.br.soluctions.attos.domus.repositories.UserRepository;
import com.br.soluctions.attos.domus.utils.RemoveJsonParameters;

@Service
public class UserService {
    UserRepository userRepository;
    RemoveJsonParameters removeJsonParameters;

    public UserService(UserRepository userRepository, RemoveJsonParameters removeJsonParameters) {
        this.userRepository = userRepository;
        this.removeJsonParameters = removeJsonParameters;
    }

    public boolean verifyEmail(String email) {

        boolean isExists = false;
        email = removeJsonParameters.removeParameters(email, "email");
        var emailResult = userRepository.findByPersonEmail(email);

        if (emailResult) {
            isExists = true;
        } else {
            isExists = false;
        }

        return isExists;

    }
}
