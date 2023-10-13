package com.TareasApp.tareasApp.service.DTO;

import com.TareasApp.tareasApp.Exceptions.toDoExceptions;
import com.TareasApp.tareasApp.Mapper.TaskinDTOToTask;
import com.TareasApp.tareasApp.Persistence.Entities.Task;
import com.TareasApp.tareasApp.Persistence.Entities.TaskStatus;
import com.TareasApp.tareasApp.Persistence.Repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    //Necesitamos que esta clase tenga 2 objetos como atributos, el repository que va a heredar de jparepository
    // y el mapper para convertir las tareas dto en tareas
    private final TaskRepository repository;
    private final TaskinDTOToTask mapper;


    //Constructor del objeto taskservice
    public TaskService(TaskRepository repository, TaskinDTOToTask mapper) {
        this.repository=repository;
        this.mapper = mapper;
    }
    // Metodo para crear una tarea
    public Task createdTask(TaskInDto taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);

    }

    // Metodo para buscar todas las tareas
    public List<Task> findAll(){
        return this.repository.findAll();
    }

    // Metodo para buscar todas las tareas dependiendo del estado ( Lo pasamos por parametro)
    public List<Task> findAllByStatus(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }

    // Marcar tarea como completada
    @Transactional
    public void taskCompleted(Long id){
        Optional<Task> optional = this.repository.findById(id);
        if(optional.isEmpty()){
            throw new toDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.taskCompleted(id);

    }

    // Borrar una tarea
    @Transactional
    public void deleteById(Long id){
        Optional<Task> optional = this.repository.findById(id);
        if(optional.isEmpty()){
            throw new toDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
            this.repository.deleteById(id);

    }
}
