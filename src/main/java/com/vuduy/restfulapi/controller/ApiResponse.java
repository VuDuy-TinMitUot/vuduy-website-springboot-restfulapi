package com.vuduy.restfulapi.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
    private String erroCode;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ApiResponse(HttpStatus HttpStatus, String message, T data, String erroCode) {
        this.status = HttpStatus.is2xxSuccessful() ? "success" : "error";
        this.message = message;
        this.data = data;
        this.erroCode = erroCode;
        this.timestamp = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErroCode() {
        return erroCode;
    }

    public void setErroCode(String erroCode) {
        this.erroCode = erroCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
