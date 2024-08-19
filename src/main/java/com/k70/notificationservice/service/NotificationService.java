package com.k70.notificationservice.service;

import com.k70.notificationservice.dto.NotificationDTO;
import com.k70.notificationservice.mapper.NotificationMapper;
import com.k70.notificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public NotificationService(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    /**
     * Controlling method free to delete
     */
    public String hello() {
        return "hello from NotificationService";
    }


    public List<NotificationDTO> getAllNotifications() {
        return notificationRepository.findAll().stream().map(notificationMapper::toNotificationDTO).toList();
    }


    public NotificationDTO save(NotificationDTO notificationDTO) {
        return notificationMapper.toNotificationDTO(notificationRepository.save(notificationMapper.toNotification(notificationDTO)));
    }
}