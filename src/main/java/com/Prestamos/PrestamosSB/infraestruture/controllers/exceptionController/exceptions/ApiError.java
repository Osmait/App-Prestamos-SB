package com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions;


import java.time.LocalDateTime;

public record ApiError(String message, int httpStatus, LocalDateTime localDateTime) {
}
