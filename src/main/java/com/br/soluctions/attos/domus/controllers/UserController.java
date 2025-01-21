package com.br.soluctions.attos.domus.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.soluctions.attos.domus.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/verify-email")
    ResponseEntity<Boolean> verifyEmail(@RequestParam String email) {
        boolean isExists = false;

        isExists = userService.verifyEmail(email);

        return ResponseEntity.ok(isExists);
    }
}
