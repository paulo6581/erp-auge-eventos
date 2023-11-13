package br.com.erp.augeventos.controller;

import br.com.erp.augeventos.model.TaskModel;
import br.com.erp.augeventos.model.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel) {
        System.out.println("Chegoou no Controller");
        return this.taskRepository.save(taskModel);

    }
}
