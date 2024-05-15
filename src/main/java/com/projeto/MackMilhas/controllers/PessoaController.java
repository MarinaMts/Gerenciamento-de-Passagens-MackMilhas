package com.projeto.MackMilhas.controllers;

import com.projeto.MackMilhas.entities.Pessoa;
import com.projeto.MackMilhas.repositories.PessoaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@RestController
public class PessoaController {
    @Autowired
    private PessoaRepo pessoaRepo;
    public PessoaController() {}


    @GetMapping("/pessoa")
    Iterable<Pessoa> getPessoa() {
        return pessoaRepo.findAll();
    }

    @GetMapping("/pessoa/{id}")
    Optional<Pessoa> getPessoa(@PathVariable(required = true, name="id") long id){
        return pessoaRepo.findById(id);
    }

    @PostMapping("/pessoa")
    Pessoa createPessoa(@RequestBody Pessoa p) {
        return pessoaRepo.save(p);
    }

    @PostMapping("/login")
    public Boolean login(@RequestBody final String nome, final String senha) {
        Pessoa p = this.pessoaRepo.findByNomeContainingIgnoreCase(nome);
        if(p != null){
            return p.getSenha().equals(senha);
        }
        return false;
    }

    @PutMapping("/pessoa/{id}")
    Optional<Pessoa> updatePessoa(@RequestBody Pessoa pessoa, @PathVariable(required = true, name="id") long id) {
        Optional<Pessoa> opt = this.getPessoa(id);
        if(opt.isPresent() && Objects.equals(opt.get().getId_pessoa(), pessoa.getId_pessoa())) {
            return Optional.of(pessoaRepo.save(pessoa));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do prefessor com id " + id);
    }

    @DeleteMapping(value = "/pessoa/{id}")
    void deletePessoa(@PathVariable(required = true, name = "id") long id) {
        pessoaRepo.deleteById(id);
    }
}
