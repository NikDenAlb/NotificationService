package com.k70.notificationservice.dto;

import java.util.UUID;

public record RoomDTO(
        UUID id,
        String number,
        TypeDto type,
        Double price
) {
}
