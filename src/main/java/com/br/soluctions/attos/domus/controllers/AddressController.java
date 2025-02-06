package com.br.soluctions.attos.domus.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.soluctions.attos.domus.services.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("get-cep")
    ResponseEntity<String> getCep(@RequestParam String cep) {
        String result = addressService.findCep(cep);

        return ResponseEntity.ok(result);

    }
}
