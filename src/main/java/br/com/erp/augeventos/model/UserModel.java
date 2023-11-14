package br.com.erp.augeventos.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name ="usuario", schema ="erp_eventos")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    private String name;

    @Column(unique = true)
    private String username;

    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column (length = 15)
    private String telefone;

    @Column (length = 200)
    private String endereco;
}
