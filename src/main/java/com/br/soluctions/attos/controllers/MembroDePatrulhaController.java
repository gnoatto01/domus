package com.br.soluctions.attos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.soluctions.attos.domus.dtos.MembroDePatrulhaDto;
import com.br.soluctions.attos.entities.MembroDePatrulha;
import com.br.soluctions.attos.services.MembroDePatrulhaService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class MembroDePatrulhaController {
    private MembroDePatrulhaService membroDePatrulhaService; 

    public MembroDePatrulhaController(MembroDePatrulhaService membroDePatrulhaService){
        this.membroDePatrulhaService = membroDePatrulhaService; 
    }

    @Transactional
    @PostMapping("/registrar-membro-patrulha")
    public ResponseEntity<MembroDePatrulha> registrarNovoMembroDePatrulha(@RequestBody MembroDePatrulhaDto mDePatrulhaDto){
        var membro = new MembroDePatrulha(); 
        membro = membroDePatrulhaService.registrarNovoMembroDePatrulha(mDePatrulhaDto); 

        return ResponseEntity.ok(membro); 
    }

    @PutMapping("/editar-membro-patrulha")
    public ResponseEntity<Void> editarMembroDePatrulha(){


        return ResponseEntity.ok().build(); 
    }
    
}
