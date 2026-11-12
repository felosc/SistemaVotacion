package com.cleycer.Votacion.exception;

import com.cleycer.Votacion.dto.ErrorResponse;
import com.sun.net.httpserver.Request;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

public class GlobalExceptionHandler {

    private ResponseEntity<ErrorResponse> buildError(HttpStatus status, String message, String path, Map<String, String> fieldErrors){
        ErrorResponse errorResponse = new ErrorResponse(status.value(),status.getReasonPhrase(),message,path,fieldErrors);
        return  ResponseEntity.status(status).body(errorResponse);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> HandlerResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {

        return buildError(HttpStatus.NOT_FOUND,ex.getMessage(),request.getRequestURI(),null);

    }

}
