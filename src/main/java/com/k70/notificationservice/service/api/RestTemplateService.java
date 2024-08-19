package com.k70.notificationservice.service.api;

import com.k70.notificationservice.dto.BookingResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
@Component
public interface RestTemplateService {
    List<BookingResponseDTO> getBookingResponseDTO(LocalDateTime startDate, LocalDateTime endDate);
}