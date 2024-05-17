package com.projeto.MackMilhas.controllers;

import com.projeto.MackMilhas.DTO.ReservaDto;
import com.projeto.MackMilhas.entities.Passagem;
import com.projeto.MackMilhas.entities.Pessoa;
import com.projeto.MackMilhas.entities.Reserva;
import com.projeto.MackMilhas.services.PassagemService;
import com.projeto.MackMilhas.services.PessoaService;
import com.projeto.MackMilhas.services.ReservaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PassagemService passagemService;

    public ReservaController() {}

    @GetMapping("/reserva")
    Iterable<Reserva> getReserva() {
        return reservaService.listAll();
    }

    @GetMapping("/reserva/{id}")
    Optional<Reserva> getReserva(@PathVariable(required = true, name="id") long id){
        return Optional.ofNullable(reservaService.findById(id));
    }

//    @PostMapping("/reserva")
//    ResponseEntity<Reserva> createReserva(@RequestBody Reserva r, @RequestBody Pessoa p, @RequestBody Passagem pass) {
//        Pessoa pessoa = this.pessoaService.findById(p.getId_pessoa());
//        Passagem passagem = this.passagemService.findById(pass.getId_passagem());
//        if(pessoa != null && passagem != null) {
//            Reserva reservaCriada = reservaService.salvaReserva(r);
//            return ResponseEntity.status(HttpStatus.CREATED).body(reservaCriada);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
    @PostMapping("/reserva")
    public ResponseEntity<Reserva> criarReserva(@RequestBody ReservaDto reservaDto) {
        Pessoa pessoa = pessoaService.findById(reservaDto.getPessoaId());
        Passagem passagem = passagemService.findById(reservaDto.getPassagemId());

        if(pessoa != null && passagem != null){
            Reserva reserva = new Reserva();
            reserva.setPessoa(pessoa);
            reserva.setPassagem(passagem);

            Reserva novaReserva = reservaService.salvaReserva(reserva);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaReserva);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
