package br.com.paulo.todolist.model.repository;

import br.com.paulo.todolist.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITaskRepository  extends JpaRepository<TaskModel, UUID> {


}
