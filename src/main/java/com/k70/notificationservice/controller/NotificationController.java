package com.k70.notificationservice.controller;


import com.k70.notificationservice.dto.NotificationDTO;
import com.k70.notificationservice.mapper.NotificationMapper;
import com.k70.notificationservice.model.Notification;
import com.k70.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    public final NotificationService notificationService;
    @Autowired
    public final NotificationMapper notificationMapper;

    //toDel
    @GetMapping("/hello")
    private String hello() {
        return "Hello from NotificationController";
    }

    //toDel
    @GetMapping("/hello/service")
    private String helloService() {
        return notificationService.hello();
    }

    @GetMapping
    public ResponseEntity<List<NotificationDTO>> getAllNotifications() {
        return new ResponseEntity<>(notificationService.getAllNotifications().stream().map(notificationMapper::toNotificationDTO).toList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notification> save(@RequestBody Notification notification) {
        return new ResponseEntity<>(notificationService.save(notification), HttpStatus.OK);
    }
}