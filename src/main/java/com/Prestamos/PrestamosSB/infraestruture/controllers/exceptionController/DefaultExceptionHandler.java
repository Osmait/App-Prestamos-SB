package com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController;


import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.ApiError;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.BadRequest;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.DuplicateResourceException;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.UnAuthorizedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class DefaultExceptionHandler {



    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<ApiError> handleException(UnAuthorizedException e) {
        ApiError apiError = new ApiError(e.getMessage(), HttpStatus.UNAUTHORIZED.value(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ApiError> handleException(BadRequest e) {
        ApiError apiError = new ApiError(e.getMessage(), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleException(RuntimeException e) {
        ApiError apiError = new ApiError(e.getMessage(), HttpStatus.FORBIDDEN.value(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiError> handleException(DuplicateResourceException e) {
        ApiError apiError = new ApiError(e.getMessage(), HttpStatus.CONFLICT.value(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }



}
