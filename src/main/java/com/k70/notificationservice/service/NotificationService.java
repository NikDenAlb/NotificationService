package com.k70.notificationservice.service;

import com.k70.notificationservice.model.Notification;
import com.k70.notificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    //toDel
    public String hello() {
        return "hello from NotificationService";
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }
}