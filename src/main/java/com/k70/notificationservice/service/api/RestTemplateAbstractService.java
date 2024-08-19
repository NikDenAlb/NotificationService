package com.k70.notificationservice.service.api;

import com.k70.notificationservice.dto.BookingResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RequiredArgsConstructor
public abstract class RestTemplateAbstractService implements RestTemplateService {

    @Value("http://localhost:8081/bookings")
    //@Value("resttemplate.url.booking")
    protected String bookingURL;

    protected final RestTemplate restTemplate;

    public abstract BookingResponseDTO getBookingResponseDTO(UUID uuid);
}
