package com.k70.notificationservice.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingResponseDTO(
        UUID id,
        HotelDTO hotel,
        RoomDTO room,
        CustomerDTO customer,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
