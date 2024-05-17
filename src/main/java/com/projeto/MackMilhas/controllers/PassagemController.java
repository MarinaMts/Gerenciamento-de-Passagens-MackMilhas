package com.projeto.MackMilhas.controllers;

import com.projeto.MackMilhas.entities.Passagem;
import com.projeto.MackMilhas.entities.Pessoa;
import com.projeto.MackMilhas.repositories.PassagemRepo;
import com.projeto.MackMilhas.services.PassagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@RestController
public class PassagemController {
    @Autowired
    private PassagemService passagemService;
    public PassagemController() {}


    @GetMapping("/passagem")
    Iterable<Passagem> getPassagem() {
        return passagemService.listAll();
    }

    @GetMapping("/passagem/{id}")
    Optional<Passagem> getPassagem(@PathVariable(required = true, name="id") long id){
        return Optional.ofNullable(passagemService.findById(id));
    }

    @PostMapping("/passagem")
    Passagem createPessoa(@RequestBody Passagem p) {
        return passagemService.salvaPassagem(p);
    }

    @PutMapping("/passagem/{id}")
    Optional<Passagem> updatePassagem(@RequestBody Passagem passagem, @PathVariable(required = true, name="id") long id) {
        Passagem passagemAtualizada = passagemService.atualizaPassagem(id, passagem);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do prefessor com id " + id);
    }

    @DeleteMapping(value = "/passagem/{id}")
    void deletePassagem(@PathVariable(required = true, name = "id") long id) {
        passagemService.deletaPassagem(id);
    }
}
