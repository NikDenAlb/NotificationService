package com.k70.notificationservice.service;

import com.k70.notificationservice.dto.BookingResponseDTO;
import com.k70.notificationservice.service.api.RestTemplateAbstractService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RestTemplateService extends RestTemplateAbstractService {

    public RestTemplateService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public List<BookingResponseDTO> getBookingResponseDTO(LocalDateTime startDate, LocalDateTime endDate) {
        String url = bookingURL + "?" + "startDate=" + startDate/*.format(DateTimeFormatter.ISO_DATE_TIME)*/
                + "&endDate=" + endDate/*.format(DateTimeFormatter.ISO_DATE_TIME)*/;
        try {
            ResponseEntity<List<BookingResponseDTO>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<BookingResponseDTO>>() {
            });
            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null;
            } else {
                throw e;
            }
        } catch (RestClientException e) {
            throw e;
        }
    }

    @Override
    public BookingResponseDTO getBookingResponseDTO(UUID uuid) {
        String url = bookingURL + "/" + uuid;
        try {
            return restTemplate.getForObject(url, BookingResponseDTO.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null;
            } else {
                throw e;
            }
        } catch (RestClientException e) {
            throw e;
        }
    }
}
