package br.com.erp.augeventos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "agenda", schema = "erp_eventos")
public class AgendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgenda;

    @Column(length = 50 )
    private String tituloEvento;

    private String dscEvento;

    private LocalDateTime  datHoraInicial;
    private LocalDateTime  datHoraFinal;

    private int idUser;
}
