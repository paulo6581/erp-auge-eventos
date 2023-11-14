package br.com.erp.augeventos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "historico_ajudante", schema = "erp_eventos")
public class HistoricoAjudanteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistoricoAjudante;

    private float vlrHistoricoAjudante;

    private LocalDateTime datHistoricoAjudante;

    @Column(length = 100)
    private String observacao;

    @Column (length =200)
    private String nmEvento;

    @ManyToOne
    @JoinColumn (name = "idAjudante")
    private AjudanteModel idAjudante;
}
