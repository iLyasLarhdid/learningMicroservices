package com.larhdid.notification;

import com.larhdid.clients.notification.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping
    public NotificationResponse sendNotification(@RequestBody NotificationResponse notificationResponse){
        return notificationService.sendNotification(notificationResponse);
    }
}
