package com.k70.notificationservice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

//	@Autowired
//	private NotificationService notificationService;

    @RequestMapping()
    private String hello() {
        return "Hello";
    }
}