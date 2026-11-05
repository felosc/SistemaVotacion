package com.cleycer.Votacion.dto;

import java.util.Map;

public class ErrorResponse {
    private int status;
    private String error;
    private String message;
    private String path;
    //esot es para errores @Valid, mas adelante veremos si lo utilizaremos
    private Map<String, String> fieldErrors;

    public ErrorResponse() {
    }

    public ErrorResponse(int status, String error, String message, String path, Map<String,String> fieldErrors) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.fieldErrors = fieldErrors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String,String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String,String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
