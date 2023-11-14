package br.com.erp.augeventos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "ajudante", schema = "erp_eventos")
public class AjudanteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAjudante;

    @Column(length = 14)
    private String cnpj;

    @ManyToOne
    @JoinColumn (name = "id_usuario")
    private UserModel idUsuario;
}
