package com.k70.notificationservice.dto;

import java.util.UUID;

public record CustomerDTO(
        UUID id,
        String firstName,
        String lastName,
        String email
) {
}
