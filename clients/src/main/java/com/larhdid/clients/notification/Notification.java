package com.larhdid.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notification",path = "api/v1/notifications")
public interface Notification {
    @PostMapping
    public NotificationResponse sendNotification(@RequestBody NotificationResponse notificationResponse);
}
