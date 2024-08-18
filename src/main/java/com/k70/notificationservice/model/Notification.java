package com.k70.notificationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;
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
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Notification {

    @Id
    @GeneratedValue
    private UUID id;
    private UUID customerId;
    private String message;
    private LocalDateTime sentAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification that)) return false;
        return Objects.equals(customerId, that.customerId) && Objects.equals(message, that.message) && Objects.equals(sentAt, that.sentAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, message, sentAt);
    }
}
