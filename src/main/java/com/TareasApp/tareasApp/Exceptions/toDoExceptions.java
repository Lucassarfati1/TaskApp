package com.TareasApp.tareasApp.Exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
public class toDoExceptions extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public toDoExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public HttpStatusCode getHttpStatus() {
    System.out.println("A ver esto");
        return null;
    }
}
