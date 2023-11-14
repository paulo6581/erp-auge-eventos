package br.com.erp.augeventos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente", schema = "erp_eventos")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column(length = 14)
    private String cnpj;

    @Column (length = 11)
    private String cpf;

    @ManyToOne
    @JoinColumn (name = "id_usuario")
    private UserModel idUsuario;
}
