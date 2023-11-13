package br.com.erp.augeventos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "evento", schema = "erp_eventos")
public class EventoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvento;

    @Column(length = 45)
    private String tipEvento;

    private LocalDateTime datHora;

    @Column(length = 200)
    private String enderecoEvento;

    private float vlrEvento;
}
