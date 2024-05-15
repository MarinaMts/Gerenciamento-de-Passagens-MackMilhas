package com.projeto.MackMilhas.configs;

import com.projeto.MackMilhas.entities.Passagem;
import com.projeto.MackMilhas.entities.Pessoa;
import com.projeto.MackMilhas.entities.Reserva;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
//        Pessoa p1 = new Pessoa(null, "Marina Lucas", "1234567");
//        Pessoa p2 = new Pessoa(null, "Gabriel Mouta", "7654321");
//
//        Passagem pass1 = new Passagem(null, "São Paulo", "Salvador", LocalDate.now(), 642.90);
//        Passagem pass2 = new Passagem(null, "Rio de Janeiro", "São Paulo", LocalDate.now(), 724.99);
//
//        Reserva reserva1 = new Reserva(null, 1, 1);
//        Reserva reserva2 = new Reserva(null, 2, 1);
//        Reserva reserva3 = new Reserva(null, 1, 2);
    }
}
