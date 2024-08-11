package com.k70.notificationservice.controller;


import com.k70.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    //toDel
    @RequestMapping("/hello")
    private String hello() {
        return "Hello from NotificationController";
    }

    //toDel
    @RequestMapping("/hello/service")
    private String helloService() {
        return notificationService.hello();
    }
}