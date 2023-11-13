package br.com.paulo.todolist.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tasks", schema = "erp_eventos")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50 )
    private String title;

    private LocalDateTime  hourStartAt;
    private LocalDateTime  hourEndAt;
    private String  priority;

    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
