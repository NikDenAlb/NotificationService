package com.k70.notificationservice.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificationDTO(
        UUID id,
        UUID customerId,
        String message,
        LocalDateTime sentAt)
{}