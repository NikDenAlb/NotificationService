package com.k70.notificationservice.repository;

import com.k70.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for already sent messages
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
