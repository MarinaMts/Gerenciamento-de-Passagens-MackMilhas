package com.projeto.MackMilhas.controllers;

import com.projeto.MackMilhas.entities.Reserva;
import com.projeto.MackMilhas.repositories.ReservaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@RestController
public class ReservaController {
    @Autowired
    private ReservaRepo reservaRepo;

    public ReservaController() {}

    @GetMapping("/reserva")
    Iterable<Reserva> getReserva() {
        return reservaRepo.findAll();
    }

    @GetMapping("/reserva/{id}")
    Optional<Reserva> getReserva(@PathVariable(required = true, name="id") long id){
        return reservaRepo.findById(id);
    }

    @PostMapping("/reserva")
    Reserva createReserva(@RequestBody Reserva r) {
        return reservaRepo.save(r);
    }

}
