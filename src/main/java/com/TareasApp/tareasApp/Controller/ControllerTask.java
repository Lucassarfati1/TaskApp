package com.TareasApp.tareasApp.Controller;


import com.TareasApp.tareasApp.Persistence.Entities.Task;
import com.TareasApp.tareasApp.Persistence.Entities.TaskStatus;
import com.TareasApp.tareasApp.service.DTO.TaskInDto;
import com.TareasApp.tareasApp.service.DTO.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/tasks")
public class ControllerTask {

    private final TaskService taskservice;

    public ControllerTask(TaskService taskservice) {
        this.taskservice = taskservice;
    }

    // Creamos una tarea, el json recibe un taskdto y lo mapeamos a un task mediante el objeto task service

    @PostMapping
    public Task createTask(@RequestBody TaskInDto taskindto) {
        return this.taskservice.createdTask(taskindto);
    }

    // Obtenemos todas las tareas guardadas

    @GetMapping("/getTasks")
    public List<Task> findAll() {

        return this.taskservice.findAll();
    }

    // Obtenemos todas las tareas dependiendo del estado
    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus status) {
        return this.taskservice.findAllByStatus(status);
    }

    // Marcamos como completada una tarea

    @PatchMapping("/taskCompleted/{id}")
    public ResponseEntity<Void> taskCompleted(@PathVariable("id") Long id) {

        this.taskservice.taskCompleted(id);

        return ResponseEntity.noContent().build();
    }

    // Borramos una tarea

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> taskDelete(@PathVariable("id") Long id) {

        this.taskservice.deleteById(id);

        return ResponseEntity.noContent().build();
    }



}

