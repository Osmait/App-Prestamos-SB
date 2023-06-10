package com.Prestamos.PrestamosSB.infraestruture.Dto;

import java.time.LocalDateTime;

public record UserResponse(Long id, String name, String lastName, String Email,  LocalDateTime createAt) {
}