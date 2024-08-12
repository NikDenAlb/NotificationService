package com.k70.notificationservice.controller;


import com.k70.notificationservice.model.Notification;
import com.k70.notificationservice.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

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
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return new ResponseEntity<>(notificationService.getAllNotifications(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notification> saveNotification(@RequestBody Notification notification) {
        return new ResponseEntity<>(notificationService.save(notification), HttpStatus.OK);
    }
}