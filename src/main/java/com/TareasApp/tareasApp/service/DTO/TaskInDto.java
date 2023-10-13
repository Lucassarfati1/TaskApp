package com.TareasApp.tareasApp.service.DTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Data
public class TaskInDto {
    private String title;
    private String description;
    private LocalDateTime eta;

    public TaskInDto(String title, String description, LocalDateTime eta) {
        this.title = title;
        this.description = description;
        this.eta = eta;
    }
}
