package com.projeto.MackMilhas.controllers;

import com.projeto.MackMilhas.entities.Passagem;
import com.projeto.MackMilhas.entities.Pessoa;
import com.projeto.MackMilhas.repositories.PassagemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@RestController
public class PassagemController {
    @Autowired
    private PassagemRepo passagemRepo;
    public PassagemController() {}

    @GetMapping("/passagem")
    Iterable<Passagem> getPassagem() {
        return passagemRepo.findAll();
    }

    @GetMapping("/passagem/{id}")
    Optional<Passagem> getPassagem(@PathVariable(required = true, name="id") long id){
        return passagemRepo.findById(id);
    }

    @PostMapping("/passagem")
    Passagem createPassagem(@RequestBody Passagem p) {
        return passagemRepo.save(p);
    }

    @PutMapping("/passagem/{id}")
    Optional<Passagem> updatePassagem(@RequestBody Passagem passagem, @PathVariable(required = true, name="id") long id) {
        Optional<Passagem> opt = this.getPassagem(id);
        if(opt.isPresent() && Objects.equals(opt.get().getId_passagem(), passagem.getId_passagem())) {
            return Optional.of(passagemRepo.save(passagem));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados da passagem com id " + id);
    }

    @DeleteMapping(value = "/passagem/{id}")
    void deletePessoa(@PathVariable(required = true, name = "id") long id) {
        passagemRepo.deleteById(id);
    }
}
