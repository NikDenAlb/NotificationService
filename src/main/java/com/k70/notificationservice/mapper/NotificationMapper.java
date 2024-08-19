package com.k70.notificationservice.mapper;

import com.k70.notificationservice.dto.NotificationDTO;
import com.k70.notificationservice.model.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationDTO toNotificationDTO(Notification notification);
    Notification toNotification(NotificationDTO notificationDTO);
}
