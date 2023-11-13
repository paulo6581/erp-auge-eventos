package br.com.erp.augeventos.model.repository;

import br.com.erp.augeventos.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITaskRepository  extends JpaRepository<TaskModel, UUID> {


}