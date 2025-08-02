package com.vuduy.restfulapi.controller.errors;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vuduy.restfulapi.controller.ApiResponse;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFound(NoSuchElementException ex) {
        var result = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "handleNotFound", null, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    /**
     * Exception chính, nơi có bất kì lỗi nào xảy ra sẽ chạy vào đây
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleAllException(Exception ex) {
        var result = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "handleAllException", null, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }
}
