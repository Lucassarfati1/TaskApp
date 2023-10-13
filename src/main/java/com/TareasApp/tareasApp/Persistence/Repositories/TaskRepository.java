package com.TareasApp.tareasApp.Persistence.Repositories;
import com.TareasApp.tareasApp.Persistence.Entities.Task;
import com.TareasApp.tareasApp.Persistence.Entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Metodo a implementar dame todas las tareas segun el estado
    List<Task> findAllByTaskStatus(TaskStatus status);

    // Metodo para marcar como cumplida la tarea
    @Modifying
    @Query(value = "update tareas set finished=true where id=:id ;", nativeQuery = true )
    void taskCompleted(@Param("id") Long id);

}
