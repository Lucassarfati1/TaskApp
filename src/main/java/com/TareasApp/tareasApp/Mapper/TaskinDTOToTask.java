package com.TareasApp.tareasApp.Mapper;


import com.TareasApp.tareasApp.Persistence.Entities.Task;
import com.TareasApp.tareasApp.Persistence.Entities.TaskStatus;
import com.TareasApp.tareasApp.service.DTO.TaskInDto;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.TareasApp.tareasApp.Persistence.Entities.TaskStatus.ON_TIME;

@Component
public class TaskinDTOToTask implements iMapper<TaskInDto, Task>{

   @Override
    public Task map(TaskInDto in){
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(ON_TIME);


        return task;
    }
}
