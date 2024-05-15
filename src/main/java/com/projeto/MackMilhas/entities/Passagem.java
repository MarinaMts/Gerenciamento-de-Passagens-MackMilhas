package com.projeto.MackMilhas.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_passagem")
@Entity
@Table(name = "passagem")
public class Passagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_passagem;

    @NotBlank
    private String origem;

    @NotBlank
    private String destino;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @FutureOrPresent
    private Date data;

    @NotNull
    private Double preco;

    @OneToOne(mappedBy = "passagem", cascade = CascadeType.ALL)
    private Reserva reserva;

}
