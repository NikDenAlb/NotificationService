package com.k70.notificationservice.dto;

import java.util.UUID;

public record HotelDTO(
        UUID id,
        String name,
        String address
) {
}
