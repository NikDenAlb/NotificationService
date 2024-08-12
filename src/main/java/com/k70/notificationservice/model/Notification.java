package com.k70.notificationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

//toDel
/**
 * <pre>
 * "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
 *
 * "customerId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
 *
 * "message": "string",
 *
 * "sentAt": "2024-08-11T15:24:12.651Z"
 * <pre/>
 **/
@Entity
@Data //toDel (need in DTO) not sure
public class Notification {

    @Id
    @GeneratedValue
    private UUID id;
    private UUID customerId;
    private String message;
    private LocalDateTime sentAt;
}
