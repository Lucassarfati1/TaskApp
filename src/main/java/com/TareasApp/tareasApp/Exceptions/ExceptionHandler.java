package com.TareasApp.tareasApp.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value={toDoExceptions.class})
    protected ResponseEntity<Object> HandleConflict(
            toDoExceptions ex, WebRequest request ){
        String bodyofresponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyofresponse,
                new HttpHeaders(), ex.getHttpStatus(), request);
    }


}
