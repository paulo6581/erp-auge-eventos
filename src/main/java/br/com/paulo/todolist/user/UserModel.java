package br.com.paulo.todolist.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name ="tb_users", schema ="erp_eventos")
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String username, name, password;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
