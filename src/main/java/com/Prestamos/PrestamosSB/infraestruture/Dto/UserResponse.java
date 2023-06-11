package com.Prestamos.PrestamosSB.infraestruture.Dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(UUID id, String name, String lastName, String Email, LocalDateTime createAt) {
}