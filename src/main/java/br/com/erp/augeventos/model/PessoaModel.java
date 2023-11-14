package br.com.erp.augeventos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoa", schema = "erp_eventos")
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPessoa;

    @Column(length = 100)
    private String nmCompleto;

    @Column(length = 15)
    private String telefone;

    @Column(length = 200)
    private String endereco;
}
